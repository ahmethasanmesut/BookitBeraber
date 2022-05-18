package com.bookit.stepDefs;

import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginStepDef {
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("user write {string} and {string}")
    public void user_write_and(String string, String string2) {

    }
    @Then("user is on the home page")
    public void user_is_on_the_home_page() {

    }
}
