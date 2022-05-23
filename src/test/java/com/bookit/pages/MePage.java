package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MePage extends BasePage{
    @FindBy(xpath = "(//p[@class='title is-6'])[1]")
    public WebElement fullName;

    @FindBy(xpath = "(//p[@class='title is-6'])[2]")
    public WebElement role;
}
