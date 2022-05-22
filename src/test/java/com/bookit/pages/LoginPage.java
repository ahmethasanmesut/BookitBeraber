package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[contains(text(),'sign in')]")
    public WebElement signInBtn;

}
