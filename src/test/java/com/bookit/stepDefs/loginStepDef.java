package com.bookit.stepDefs;

import com.bookit.pages.LoginPage;
import com.bookit.utilities.BrowserUtils;
import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class loginStepDef {
    WebDriverWait wait = new WebDriverWait(Driver.get(),10);
    LoginPage loginPage = new LoginPage();
    String token2;
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("user write {string} and {string}")
    public void user_write_and(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailBox));
        loginPage.emailBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.signInBtn.click();
        token2 = pageMeStepDefs.apiToken;
    }
    @Then("user is on the home page")
    public void user_is_on_the_home_page() {
        wait.until(ExpectedConditions.urlMatches("https://cybertek-reservation-qa3.herokuapp.com/map"));
        String expectedUrl = "https://cybertek-reservation-qa3.herokuapp.com/map";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals("User is not on the homepage",expectedUrl,actualUrl);
    }
}