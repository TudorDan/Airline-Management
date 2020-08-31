package com.codecool.airlineSubjects;

import com.codecool.utilities.EmployeeType;
import com.codecool.utilities.Language;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightAttendant extends Employee {
    private final List<Language> languageList = new ArrayList<>();

    public FlightAttendant(String name, String phoneNumber, Date date, BigDecimal salary, List<Language> languages) {
        super(name, phoneNumber, date, salary);
        setEmployeeType(EmployeeType.FLIGHTATTENDANT);
        languageList.addAll(languages);
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    @Override
    public void showEmployeeData() {
        super.showEmployeeData();
        System.out.println("Employee " + getEmployeeType() + " " + getName() + " phone: " + getPhoneNumber() + " " +
                "birthdate: " + getBirthDate() + " salary: " + getSalary() + " $. Known languages: " + languageList.toString());
    }
}
