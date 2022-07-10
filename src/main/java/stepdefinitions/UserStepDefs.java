package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.mapper.factory.DefaultJackson2ObjectMapperFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateUserPojo;
import utils.PayloadUtils;

import java.lang.reflect.Type;
import java.rmi.MarshalledObject;
import java.util.Map;

public class UserStepDefs {

    Response response;
    RequestSpecification requestSpecification;
    @Given("user has proper authorization {string} {string}")
    public void userHasProperAuthorization(String token, String basePath) throws JsonProcessingException {

        RestAssured.baseURI = "https://gorest.co.in/public-api";
        RestAssured.basePath = basePath;


        requestSpecification = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .header("Authorization", token);
    }

    @When("user provides body information")
    public void user_provides_body_information() {
        response = requestSpecification.when().body(PayloadUtils.createUserBody()).post();
    }

    @Then("user gets response of created user")
    public void userGetsResponseOfCreatedUser() throws JsonProcessingException {

        response.then().statusCode(200).extract().response();

        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        Map<String, Object> parsedResponse =mapper.readValue(response.getBody().asString(), new TypeReference<Map<String, Object>>() {
        });

        System.out.println(parsedResponse);

        Map<String, Object> map = (Map<String, Object>) parsedResponse.get("data");
        System.out.println(map.get("id"));
    }

    @Then("user gets response")
    public void userGetsResponse() throws JsonProcessingException {
        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        response = requestSpecification.when().delete().then().statusCode(200).extract().response();
        Map<String, Object> parsedResponse =mapper. readValue(response.getBody().asString(), new TypeReference<Map<String, Object>>() {
        });
        System.out.println(parsedResponse);

    }
}
