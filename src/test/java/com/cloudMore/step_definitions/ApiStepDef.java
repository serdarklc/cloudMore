package com.cloudMore.step_definitions;

import com.cloudMore.pojos.UserCreationsPojo;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;


public class ApiStepDef {

    UserCreationsPojo userCreationsPojo = new UserCreationsPojo();

    Faker faker = new Faker();
    int id = faker.number().randomDigitNotZero();
    String userName = faker.name().username();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String phone = faker.numerify("###########");
    int userStatus = 0;



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

       System.out.println("userCreationsPojo = " + userCreationsPojo);

    }
    @Then("User can create account")
    public void user_can_create_account() {

        RestAssured.given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                and().body(userCreationsPojo).
                when().post("https://petstore.swagger.io/v2/user/createWithList").
                then().statusCode(200).log().body().
                assertThat().body("type",Matchers.is("ok"),"code",Matchers.is(200));

    }

}
