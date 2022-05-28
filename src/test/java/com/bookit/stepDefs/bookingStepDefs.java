package com.bookit.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bookingStepDefs {

    @When("user books one {string} room on this {string} at time slot between {string} and {string}")
    public void userBooksOneRoomOnThisAtTimeSlotBetweenAnd(String roomName, String date, String beginning, String ending) {

    }

    @Then("reserved room is displayed in schedule")
    public void reserved_room_is_displayed_in_schedule() {


    }



}
