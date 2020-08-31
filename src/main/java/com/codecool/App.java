package com.codecool;

import com.codecool.airlineSubjects.*;
import com.codecool.utilities.Language;
import com.codecool.utilities.Utility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("Starting Airline Management Simulation!");

        AirlineManagement airline = AirlineManagement.getInstance();
        System.out.println("Hiring employees...");
        airline.hireEmployee(new Pilot("Tetius Iulianus", "0232210153", new GregorianCalendar(1920, Calendar.AUGUST,
         30).getTime(), new BigDecimal("3000")));
        airline.hireEmployee(new Pilot("Cornelius Fuscus", "0263311911", new GregorianCalendar(1921, Calendar.SEPTEMBER,
                25).getTime(), new BigDecimal("3200")));
        List<Language> languagesAttendant1 = new ArrayList<>();
        languagesAttendant1.add(Language.ENGLISH);
        languagesAttendant1.add(Language.GERMAN);
        languagesAttendant1.add(Language.SPANISH);
        airline.hireEmployee(new FlightAttendant("Dapyx", "0263212722", new GregorianCalendar(1933,
                Calendar.MARCH, 22).getTime(), new BigDecimal("2200"), languagesAttendant1));
        List<Language> languagesAttendant2 = new ArrayList<>();
        languagesAttendant2.add(Language.ENGLISH);
        languagesAttendant2.add(Language.RUSSIAN);
        languagesAttendant2.add(Language.GERMAN);
        airline.hireEmployee(new FlightAttendant("Zyraxes", "0263456789", new GregorianCalendar(1937,
                Calendar.SEPTEMBER, 18).getTime(), new BigDecimal("2000"), languagesAttendant2));
        List<Language> languagesAttendant3 = new ArrayList<>();
        languagesAttendant3.add(Language.ENGLISH);
        languagesAttendant3.add(Language.SPANISH);
        languagesAttendant3.add(Language.RUSSIAN);
        airline.hireEmployee(new FlightAttendant("Cotiso", "0263123456", new GregorianCalendar(1940,
                Calendar.NOVEMBER, 17).getTime(), new BigDecimal("2100"), languagesAttendant3));
        List<Language> languagesAttendant4 = new ArrayList<>();
        languagesAttendant4.add(Language.GERMAN);
        languagesAttendant4.add(Language.RUSSIAN);
        languagesAttendant4.add(Language.SPANISH);
        airline.hireEmployee(new FlightAttendant("Deceneu", "0263123789", new GregorianCalendar(1922,
                Calendar.OCTOBER, 14).getTime(), new BigDecimal("1900"), languagesAttendant4));

        System.out.println("providing pilots with Compasses..");
        airline.provideAnalogCompasses();

        System.out.println("Current employees: ");
        for (Employee employee : airline.getEmployeeList()) {
            employee.showEmployeeData();
        }

        System.out.println("Creating Flight");
        int randomPassengerNumber = Utility.getRandomNumberInRange(100, 250);
        List<Passenger> passengerList = new ArrayList<>();
        for (int i = 0; i < randomPassengerNumber; i++) {
            Language randomLanguage = Language.values()[Utility.getRandomNumberInRange(0, 3)];
            passengerList.add(new Passenger(randomLanguage));
        }
        airline.addFlight(new Flight(passengerList));

        airline.processFlights();

        System.out.println("Airline Management Simulation finished!");
    }
}
