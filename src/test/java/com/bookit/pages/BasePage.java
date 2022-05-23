package com.bookit.pages;

import com.bookit.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
     BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void homePageLinks(String link){
         Driver.get().findElement(By.partialLinkText(link)).click();
    }
}
