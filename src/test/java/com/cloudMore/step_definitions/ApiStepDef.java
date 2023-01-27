package com.cloudMore.step_definitions;

import com.cloudMore.pojos.User;
import com.cloudMore.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ApiStepDef {
    @Before
    public static void init() {
        baseURI = ConfigurationReader.get("apiUrl");
    }

    User user;
    Faker faker = new Faker();
    Object[] array = {user};
    Response response;
    JsonPath jsonPath;

    @Given("User information should be written randomly")
    public void user_information_should_be_written_randomly() {
        user = User.builder().id(faker.number().randomDigitNotZero()).username(faker.name().username()).firstName(faker.name().firstName()).
                lastName(faker.name().lastName()).email(faker.internet().emailAddress()).password(faker.internet().password()).
                phone(faker.numerify("###########")).userStatus(0).build();

        System.out.println("array = " + Arrays.asList(array));
    }

    @When("User should post information")
    public void user_should_post_information() {
        response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                and().body(array).
                when().post("/user/createWithList");
    }

    @Then("User should see status code like {int}")
    public void user_should_see_status_code_like(Integer statusCode) {
        Assertions.assertEquals(response.statusCode(), statusCode);
    }

    @Then("User should see message, code, type and values")
    public void user_should_see_message_code_type_and_values() {
        response.then().assertThat().
                body("message", is("ok"), "code", is(200), "type", is("unknown"));
    }

    @When("User send a get request with username")
    public void user_send_a_get_request_with_username() {
        response = given().accept(ContentType.JSON).
                and().pathParam("username", user.getUsername()).
                when().get("user/{username}");

        System.out.println(user.getUsername());
    }

    @Then("User should see all information correctly")
    public void user_should_see_all_information_correctly() {
        jsonPath = response.jsonPath();
        assertThat(jsonPath.getInt("id"),is(user.getId()));
        assertThat(jsonPath.getString("username"),is(user.getUsername()));
        assertThat(jsonPath.getString("firstName"),is(user.getFirstName()));
        assertThat(jsonPath.getString("lastName"),is(user.getLastName()));
        assertThat(jsonPath.getString("email"),is(user.getEmail()));
        assertThat(jsonPath.getString("password"),is(user.getPassword()));
        assertThat(jsonPath.getString("phone"),is(user.getPhone()));
        assertThat(jsonPath.getInt("userStatus"),is(user.getUserStatus()));
    }

    @When("User send a update request with username")
    public void user_send_a_update_request_with_username() {

        array[2] = "Jack";

        response = given().accept(ContentType.JSON).
                body(array).
                and().pathParam("username", user.getUsername()).
                when().put("user/{username}");
    }

    @When("User send a delete request with username")
    public void user_send_a_delete_request_with_username() {
        response = given().accept(ContentType.JSON).
                and().pathParam("username", user.getUsername()).
                when().delete("user/{username}");
    }
    @Then("User information should be deleted")
    public void user_information_should_be_deleted() {
        assertThat(jsonPath.getInt("id"),is(null));
    }

}
