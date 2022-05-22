package com.bookit.pages;

import com.bookit.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
     BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
