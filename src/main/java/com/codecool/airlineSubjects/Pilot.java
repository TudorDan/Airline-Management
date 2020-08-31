package com.codecool.airlineSubjects;

import com.codecool.utilities.EmployeeType;
import com.codecool.utilities.PilotFlightPosition;

import java.math.BigDecimal;
import java.util.Date;

public class Pilot extends Employee {
    private PilotFlightPosition currentFlightPosition;
    private boolean receivedPremiumCompass;

    public Pilot(String name, String phoneNumber, Date date, BigDecimal salary) {
        super(name, phoneNumber, date, salary);
        setEmployeeType(EmployeeType.PILOT);
        this.receivedPremiumCompass = false;
        this.currentFlightPosition = PilotFlightPosition.UNASSIGNED;
    }

    public void setCurrentFlightPosition(PilotFlightPosition currentFlightPosition) {
        this.currentFlightPosition = currentFlightPosition;
    }

    public boolean hasPremiumCompass() {
        return receivedPremiumCompass;
    }

    public void setReceivedPremiumCompass(boolean receivedPremiumCompass) {
        this.receivedPremiumCompass = receivedPremiumCompass;
    }

    @Override
    public void showEmployeeData() {
        super.showEmployeeData();
        System.out.println("Employee " + getEmployeeType() + " " + getName() + " phone: " + getPhoneNumber() + " " +
                "birthdate: " + getBirthDate() + " salary: " + getSalary() + " $. Current flight status " + currentFlightPosition);
    }
}
