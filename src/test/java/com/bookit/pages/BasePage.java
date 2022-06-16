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

    public static String dateConventer(String date){
        String[] arr = date.split(" ");
        String monthName = arr[0];

        String months = "0";
        switch (monthName){
            case "Jan":
                months = "1";
                break;

            case "Feb":
                months = "2";
                break;

            case "Mar":
                months = "3";
                break;

            case "Apr":
                months = "4";
                break;

            case "May":
                months = "5";
                break;

            case "Jun":
                months = "6";
                break;

            case "Jul":
                months = "7";
                break;

            case "Aug":
                months = "8";
                break;

            case "Sep":
                months = "9";
                break;

            case "Oct":
                months = "10";
                break;

            case "Nov":
                months = "11";
                break;

            case "Dec":
                months = "12";
                break;
        }
        String result = months +"/"+ arr[1];
        return result;

    }

}
