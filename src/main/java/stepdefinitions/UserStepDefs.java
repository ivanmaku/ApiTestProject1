package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserStepDefs {
    @Given("user has proper authorization {string}")
    public void userHasProperAuthorization(String token) {
    }

    @When("user provides body information")
    public void user_provides_body_information() {
    }

    @Then("user gets response of created user")
    public void userGetsResponseOfCreatedUser() {
    }
}
