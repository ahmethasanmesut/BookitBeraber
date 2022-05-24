package com.bookit.stepDefs;

import com.bookit.pages.DashboardPage;
import com.bookit.pages.LoginPage;
import com.bookit.pages.MePage;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.baseURI;

public class pageMeStepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    MePage mePage = new MePage();
    String fullNameUI;
    String roleUI;
    String fullNameAPI;
    String roleAPI;

    protected static String apiToken;
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
        baseURI = ConfigurationReader.get("api_url");

        Response response1 = RestAssured.given().accept(ContentType.JSON).queryParams("email", ConfigurationReader.get("studentEmail"),
                        "password", ConfigurationReader.get("password"))
                .when().get("/sign");
        response1.prettyPrint();
        String token = response1.path("accessToken");
        apiToken = "Bearer "+ token;

        Response response = RestAssured.given().accept(ContentType.JSON)
                .header("Authorization",apiToken)
                .when().get("/api/users/me");
        System.out.println("response.statusCode() = " + response.statusCode());
        String firstName = (String)response.path("firstName");
        String lastName = (String)response.path("lastName");
        fullNameAPI = firstName +" "+ lastName;
        roleAPI = response.path("role");
        System.out.println("fullNameAPI = " + fullNameAPI);
        System.out.println("roleAPI = " + roleAPI);

    }
    @When("user obtains fullname and roles from Database")
    public void user_obtains_fullname_and_roles_from_database() {


    }
    @Then("UI information matches with API")
    public void ui_information_matches_with_api() {
        Assert.assertEquals("'FullName' does NOT match",fullNameAPI,fullNameUI);
        Assert.assertEquals("'Role' does NOT match",roleAPI,roleUI);
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
