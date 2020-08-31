package com.codecool;

import com.codecool.airlineSubjects.Employee;
import com.codecool.airlineSubjects.Flight;
import com.codecool.airlineSubjects.Pilot;
import com.codecool.utilities.EmployeeType;

import java.util.ArrayList;
import java.util.List;

public class AirlineManagement {
    private static AirlineManagement instance = null;
    private final List<Employee> employeeList = new ArrayList<>();
    private final List<Flight> flightList = new ArrayList<>();

    public static AirlineManagement getInstance() {
        if (instance == null) {
            instance = new AirlineManagement();
        }
        return instance;
    }

    public void hireEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public void provideAnalogCompasses() {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeType() == EmployeeType.PILOT) {
                Pilot pilot = (Pilot) employee;
                pilot.setReceivedPremiumCompass(true);
            }
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void processFlights() {
        System.out.println("Checking flights readiness for take off...");
        for (Flight flight : flightList) {
            List<Employee> crew = flight.getFlightCrew();
            System.out.println("Flight " + flight.getId() + " language is " + flight.getFlightLanguage());
            System.out.println("Flight" + flight.getId() + " Crew is made of:");
            for (Employee employee : crew) {
                employee.showEmployeeData();
            }
            if (flight.isReadyToTakeOff()) {
                System.out.println("Flight" + flight.getId() + " has taken off!");
            } else {
                System.out.println("Flight" + flight.getId() + " is still doing the checkouts...");
            }
        }
    }
}
