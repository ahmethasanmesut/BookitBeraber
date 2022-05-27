package com.bookit.stepDefs;

import com.bookit.pages.DashboardPage;
import com.bookit.pages.LoginPage;
import com.bookit.pages.MePage;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.DBUtils;
import com.bookit.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class pageMeStepDefs {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    MePage mePage = new MePage();
    String fullNameUI;
    String roleUI;
    String fullNameAPI;
    String roleAPI;
    String fullNameDB;
    String roleDB;

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
    @And("user gets fullName and role from API  {string} and {string}")
    public void userGetsFullNameAndRoleFromAPIAnd(String username, String password) {

        baseURI = ConfigurationReader.get("api_url");

        Response response1 = RestAssured.given().accept(ContentType.JSON).queryParams("email",username,
                "password",password)
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
    @And("user obtains fullname and roles from Database  {string} and {string}")
    public void userObtainsFullnameAndRolesFromDatabaseAnd(String username, String password) {
        DBUtils.createConnection();
        Map<String, Object> rowMap = DBUtils.getRowMap("select firstname ||' '|| lastname as \"fullname\", role\n" +
                "from users\n" +
                "where email = '"+username+"'");

        fullNameDB = (String) rowMap.get("fullname");
        System.out.println("fullNameDB = " + fullNameDB);
        roleDB = (String) rowMap.get("role");
        System.out.println("roleDB = " + roleDB);
    }
    @Then("UI information matches with API")
    public void ui_information_matches_with_api() {
        Assert.assertEquals("'FullName' does NOT match",fullNameAPI,fullNameUI);
        Assert.assertEquals("'Role' does NOT match",roleAPI,roleUI);
    }
    @Then("API information matches with Database")
    public void api_information_matches_with_database() {
        Assert.assertEquals("Not Matching",fullNameDB,fullNameAPI);
        Assert.assertEquals("Not Matching",roleDB,roleAPI);
    }
    @Then("UI information matches with Database")
    public void ui_information_matches_with_database() {
        Assert.assertEquals("Not Matching",fullNameDB,fullNameUI);
        Assert.assertEquals("Not Matching",roleDB,roleUI);
    }


}
