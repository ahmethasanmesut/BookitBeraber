package com.bookit.pages;

import com.bookit.utilities.Driver;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class BookingPage extends BasePage{

    //@FindBy(xpath = "//button[@aria-label='Open calendar']")
    //public WebElement calDate;
    Faker faker = new Faker();

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement datelocator;

    @FindBy(xpath = "(//time[@datetime='2016-1-1'])[1]")
    public WebElement bookedDate;

    @FindBy(xpath = "(//time[@datetime='2016-1-1'])[2]")
    public WebElement bookedTime;

    @FindBy(xpath = "(//p[@class='title is-size-4'])[1]")
    public WebElement bookedRoomName;

    @FindBy(tagName = "mat-icon")
    public WebElement searchBtn;

    @FindBy(xpath = "(//div[@class='mat-select-arrow-wrapper'])[1]")
    public WebElement reserveHoursFromBtn;

    @FindBy(xpath = "(//div[@class='mat-select-arrow-wrapper'])[2]")
    public WebElement reserveHoursToBtn;

    @FindBy(css = "#mat-input-0")
    public WebElement chooseDate;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement confirm;

    @FindBy(xpath = "(//a[@routerlink='/schedule/my'])[2]")
    public WebElement schedule;

    @FindBy(xpath = "//button[@class='button is-danger']")
    public WebElement cancelBooking;

      @Test
    public void getSchedule(){

        Calendar calendar = Calendar.getInstance();
          System.out.println("calendar = " + calendar);

          // Date c = calendar.getTime();

        SimpleDateFormat df = new SimpleDateFormat("M/d");
          //String current_Date = df.format(c);
          //System.out.println("current_Date = " + current_Date);

          calendar.add(Calendar.DAY_OF_YEAR, 1);


          Date c = calendar.getTime();
        String tomorrow_Date = df.format(c);
        System.out.println("tomorrow_Date = " + tomorrow_Date);

    }



    public void reserveHours(String hours){

        Driver.get().findElement(By.xpath("(//span[contains(text(), '"+hours+"' )])[1]")).click();
    }

    public void roomBooking(String roomName){
        Driver.get().findElement(By.xpath("//p[contains(text(),'"+roomName+"')]/../../footer/div/button")).click();

    }





}
