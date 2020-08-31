package com.codecool.airlineSubjects;

import com.codecool.AirlineManagement;
import com.codecool.utilities.EmployeeType;
import com.codecool.utilities.Language;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;

public class FlightTest {
    private static final AirlineManagement airline = AirlineManagement.getInstance();

    @BeforeClass
    public static void init() {
        airline.hireEmployee(new Pilot("Pilot1", "123", new GregorianCalendar(1982,
                Calendar.AUGUST, 29).getTime(), new BigDecimal("1200")));
        airline.hireEmployee(new Pilot("Pilot2", "456", new GregorianCalendar(1981,
                Calendar.FEBRUARY, 16).getTime(), new BigDecimal("1250")));

        airline.hireEmployee(new FlightAttendant("Attendant1", "123", new GregorianCalendar(1982,
                Calendar.OCTOBER, 20).getTime(), new BigDecimal("1100"),
                new ArrayList<>(Arrays.asList(Language.ENGLISH, Language.GERMAN, Language.SPANISH))));
        airline.hireEmployee(new FlightAttendant("Attendant2", "258", new GregorianCalendar(1982,
                Calendar.NOVEMBER, 9).getTime(), new BigDecimal("1000"),
                new ArrayList<>(Arrays.asList(Language.RUSSIAN, Language.SPANISH, Language.ENGLISH))));
        airline.hireEmployee(new FlightAttendant("Attendant3", "753", new GregorianCalendar(1982,
                Calendar.MARCH, 15).getTime(), new BigDecimal("1150"),
                new ArrayList<>(Arrays.asList(Language.RUSSIAN, Language.GERMAN, Language.ENGLISH))));
        airline.hireEmployee(new FlightAttendant("Attendant4", "159", new GregorianCalendar(1982,
                Calendar.MARCH, 15).getTime(), new BigDecimal("1050"),
                new ArrayList<>(Arrays.asList(Language.RUSSIAN, Language.GERMAN, Language.SPANISH))));
    }

    @Test
    public void testSetFlightCrew() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(Language.GERMAN));
        passengers.add(new Passenger(Language.ENGLISH));
        passengers.add(new Passenger(Language.SPANISH));
        passengers.add(new Passenger(Language.SPANISH));
        airline.addFlight(new Flight(passengers));

        List<Flight> flights = airline.getFlightList();
        for (Flight flight : flights) {
            List<FlightAttendant> flightAttendants = new ArrayList<>();
            for (Employee employee : flight.getFlightCrew()) {
                if (employee.getEmployeeType() == EmployeeType.FLIGHTATTENDANT) {
                    flightAttendants.add((FlightAttendant) employee);
                }
            }
            for (FlightAttendant flightAttendant : flightAttendants) {
                assertTrue(flightAttendant.getLanguageList().contains(Language.SPANISH));
            }
        }
    }

    @Test
    public void testSetFlightLanguage() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(Language.GERMAN));
        passengers.add(new Passenger(Language.ENGLISH));
        passengers.add(new Passenger(Language.GERMAN));
        passengers.add(new Passenger(Language.ENGLISH));
        airline.addFlight(new Flight(passengers));
        List<Flight> flights = airline.getFlightList();
        for (Flight flight : flights) {
            flight.setFlightLanguage();
            assertEquals(Language.GERMAN, flight.getFlightLanguage());
        }
    }
}