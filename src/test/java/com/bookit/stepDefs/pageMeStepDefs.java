package com.bookit.stepDefs;

import com.bookit.pages.DashboardPage;
import com.bookit.pages.LoginPage;
import com.bookit.pages.MePage;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class pageMeStepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    MePage mePage = new MePage();
    String fullNameUI;
    String roleUI;
    @Given("user logged in homepage with following credentials {string} and {string}")
    public void userLoggedInHomepageWithFollowingCredentialsAnd(String username, String password) {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.emailBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.signInBtn.click();
    }

    @Given("user clicks {string} button")
    public void user_clicks_button(String my) {
       dashboardPage.homePageLinks(my);
    }
    @Given("user clicks {string} title")
    public void user_clicks_title(String self) {
      dashboardPage.homePageLinks(self);
    }
    @When("user takes user's fullName and user's role")
    public void user_takes_user_s_and_user_s() {
        fullNameUI = mePage.fullName.getText();
        roleUI = mePage.role.getText();
        System.out.println("fullNameUI = " + fullNameUI);
        System.out.println("roleUI = " + roleUI);
    }
    @When("user gets fullName and role from API")
    public void user_gets_fullname_and_role_from_api() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user obtains fullname and roles from Database")
    public void user_obtains_fullname_and_roles_from_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("UI information matches with API")
    public void ui_information_matches_with_api() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("API information matches with Database")
    public void api_information_matches_with_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("UI information matches with Database")
    public void ui_information_matches_with_database() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
