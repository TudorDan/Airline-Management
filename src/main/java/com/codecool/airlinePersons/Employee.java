package com.codecool.airlinePersons;

import java.math.BigDecimal;
import java.util.Date;

public abstract class Employee {
    private final String name;
    private String phoneNumber;
    private final Date date;
    private BigDecimal salary;

    public Employee(String name, String phoneNumber, Date date, BigDecimal salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.salary = salary;
    }
}
