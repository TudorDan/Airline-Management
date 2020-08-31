package com.codecool.airlineSubjects;

import com.codecool.utilities.EmployeeType;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {
    private final String name;
    private final String phoneNumber;
    private final Date birthDate;
    private final BigDecimal salary;
    private EmployeeType employeeType;

    public Employee(String name, String phoneNumber, Date date, BigDecimal salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = date;
        this.salary = salary;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void showEmployeeData() {}

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("k:m, MMMM dd, yyyy, z Z");
        return sdf.format(birthDate);
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
