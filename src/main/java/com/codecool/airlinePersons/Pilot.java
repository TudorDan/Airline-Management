package com.codecool.airlinePersons;

import com.codecool.utilities.PilotFlightPosition;

import java.math.BigDecimal;
import java.util.Date;

public class Pilot extends Employee {
    private PilotFlightPosition currentFlightPosition;
    private boolean hasPremiumCompass;

    public Pilot(String name, String phoneNumber, Date date, BigDecimal salary) {
        super(name, phoneNumber, date, salary);
        this.hasPremiumCompass = false;
        this.currentFlightPosition = PilotFlightPosition.UNASSIGNED;
    }
}
