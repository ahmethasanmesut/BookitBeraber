package com.bookit.stepDefs;

import com.bookit.pages.BookingPage;
import com.bookit.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class bookingStepDefs {
    Calendar calendar = Calendar.getInstance();
    Date date;
    String nameOfRoom;
    String beginningOfTheTime;
    String endingOfTheTime;
    SimpleDateFormat sdf = new SimpleDateFormat("MMM/dd/yyyy");
    BookingPage bookingPage = new BookingPage();
    @When("user books one {string} room for tomorrow at time slot between {string} and {string}")
    public void userBooksOneRoomForTomorrowAtTimeSlotBetweenAnd(String roomName, String beginning, String ending) {
        BrowserUtils.waitFor(2);
        bookingPage.homePageLinks("hunt");
        BrowserUtils.waitFor(2);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        date = calendar.getTime();
        String tomorrowDate = sdf.format(date);
        bookingPage.chooseDate.sendKeys(tomorrowDate);
        bookingPage.reserveHoursFromBtn.click();
        BrowserUtils.waitFor(5);
        bookingPage.reserveHours(beginning);
        BrowserUtils.waitFor(3);
        bookingPage.reserveHoursToBtn.click();
        BrowserUtils.waitFor(5);
        bookingPage.reserveHours(ending);
        BrowserUtils.waitFor(5);
        bookingPage.searchBtn.click();
        BrowserUtils.waitFor(5);
        bookingPage.roomBooking(roomName);
        BrowserUtils.waitFor(5);
        bookingPage.confirm.click();
        BrowserUtils.waitFor(8);
        bookingPage.schedule.click();
        BrowserUtils.waitFor(4);
        bookingPage.datelocator.click();
        BrowserUtils.waitFor(5);
        nameOfRoom = roomName;
        beginningOfTheTime = beginning;
        endingOfTheTime = ending;
    }

    @Then("reserved room is displayed in schedule")
    public void reserved_room_is_displayed_in_schedule() {
        String expectedRoomName = nameOfRoom;
        String actualRoomName = bookingPage.bookedRoomName.getText();
        Assert.assertEquals("Room names not matched",expectedRoomName,actualRoomName);

        String expectedTimeInterval = beginningOfTheTime + " - " + endingOfTheTime;
        String actualTimeInterval = bookingPage.bookedTime.getText();
        Assert.assertEquals("Time not matching",expectedTimeInterval,actualTimeInterval);
        BrowserUtils.waitFor(3);
        bookingPage.cancelBooking.click();
        BrowserUtils.waitFor(3);

    }


    @Then("UI booking matches with Database information")
    public void uiBookingMatchesWithDatabaseInformation() {

    }
}
