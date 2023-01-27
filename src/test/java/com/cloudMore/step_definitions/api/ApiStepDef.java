package com.cloudMore.step_definitions.api;

import com.cloudMore.pojos.User;
import com.cloudMore.utilities.ConfigurationReader;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
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
    User user = User.getInstance();
    Response response;
    JsonPath jsonPath;
    User[] array = new User[]{user};

    @When("User should post information")
    public void user_should_post_information() {
        response = given().accept(ContentType.JSON).
                and().contentType(ContentType.JSON).
                and().body(array).
                when().post("/user/createWithList");
        System.out.println(user.getUsername());
    }

    @Then("User should see status code like {int}")
    public void user_should_see_status_code_like(Integer statusCode) {
        Assertions.assertEquals(statusCode,response.statusCode());
    }

    @Then("User should see response body code {int}")
    public void user_should_see_response_body_code(Integer code) {
        response.then().assertThat().
                body("code", is(code));
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

        System.out.println(user.getUsername());

        user.setFirstName("Jack");

        System.out.println(user.getFirstName());
        System.out.println(Arrays.asList(array));

        Gson gson = new Gson();
        String json = gson.toJson(array[0]);

        System.out.println(json);

        response = given().accept(ContentType.JSON).
                body(json).
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
        assertThat(jsonPath.getString("username"),is(null));
    }

}
