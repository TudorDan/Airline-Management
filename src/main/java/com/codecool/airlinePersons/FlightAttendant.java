package com.codecool.airlinePersons;

import com.codecool.utilities.Language;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightAttendant extends Employee {
    private final List<Language> languageList = new ArrayList<>();

    public FlightAttendant(String name, String phoneNumber, Date date, BigDecimal salary, List<Language> languages) {
        super(name, phoneNumber, date, salary);
        languageList.addAll(languages);
    }

    public List<Language> getLanguageList() {
        return languageList;
    }
}
