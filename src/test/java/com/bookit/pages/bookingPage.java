package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class bookingPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'hunt')]")
    public WebElement huntBtn;



}
