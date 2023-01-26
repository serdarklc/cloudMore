package com.cloudMore.step_definitions;

import com.cloudMore.pojos.UserCreationsPojo;
import com.cloudMore.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class ApiStepDef {

    @Before
    public static void init() {
    baseURI =ConfigurationReader.get("apiUrl");
    }
    UserCreationsPojo userCreationsPojo = new UserCreationsPojo();

    Faker faker = new Faker();
    int id = faker.number().randomDigitNotZero();
    String userName = "jack";
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String phone = faker.numerify("###########");
    int userStatus = 0;
    Object[] array = {userCreationsPojo};
    JsonPath userNameJson;

    JsonPath jsonPath;
    String responseUserName;


    @Given("User can write information")
    public void user_can_write_information() {

       userCreationsPojo.setId(id);
       userCreationsPojo.setUsername(userName);
       userCreationsPojo.setFirstName(firstName);
       userCreationsPojo.setLastName(lastName);
       userCreationsPojo.setEmail(email);
       userCreationsPojo.setPassword(password);
       userCreationsPojo.setPhone(phone);
       userCreationsPojo.setUserStatus(userStatus);

       System.out.println("array = " + Arrays.asList(array));

    }
    @Then("User can create account")
    public void user_can_create_account() {

        /*given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                and().body(array).
                when().post("/user/createWithList").
                then().statusCode(200).log().body().
                assertThat().
                body("message", is("ok"),"code", is(200),"type", is("unknown"));*/

        Response response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                and().body(array).
                when().post("/user/createWithList");

        Assertions.assertEquals(response.statusCode(), 200);
        jsonPath = response.jsonPath();
        responseUserName = jsonPath.getString("array[0].username");

    }

    @Given("Choose user with created userName")
    public void choose_user_with_created_user_name() {

        Response response =
                given().accept(ContentType.JSON).
                and().pathParam("username", responseUserName).
                when().get("user/{username}");

        System.out.println(responseUserName);

        Assertions.assertEquals(200 , response.statusCode());

    }
    @Then("User information will be matched correctly")
    public void user_information_will_be_matched_correctly() {

        assertThat(userNameJson.getInt("id"),is(id));
        assertThat(userNameJson.getString("username"),is(userName));
        assertThat(userNameJson.getString("firstName"),is(firstName));
        assertThat(userNameJson.getString("lastName"),is(lastName));
        assertThat(userNameJson.getString("email"),is(email));
        assertThat(userNameJson.getString("password"),is(password));
        assertThat(userNameJson.getString("phone"),is(phone));
        assertThat(userNameJson.getInt("userStatus"),is(userStatus));

    }






}
