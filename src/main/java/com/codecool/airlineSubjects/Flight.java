package com.codecool.airlineSubjects;

import com.codecool.AirlineManagement;
import com.codecool.utilities.EmployeeType;
import com.codecool.utilities.Language;
import com.codecool.utilities.PilotFlightPosition;

import java.util.*;

public class Flight {
    private final UUID id;
    private final List<Employee> flightCrew = new ArrayList<>();
    private final List<Passenger> passengers = new ArrayList<>();
    private Language flightLanguage;

    public Flight(List<Passenger> passengers) {
        this.id = UUID.randomUUID();
        this.passengers.addAll(passengers);
        setFlightLanguage();
        setFlightCrew();
    }

    public void addCrewMember(Employee employee) {
        flightCrew.add(employee);
    }

    public void setFlightCrew() {
        List<Employee> employees = AirlineManagement.getInstance().getEmployeeList();
        int pilotsNumber = 0;
        int flightAttendantsNumber = 0;
        for (Employee employee : employees) {
            if (employee.getEmployeeType() == EmployeeType.PILOT) {
                Pilot pilot = (Pilot) employee;
                if (pilotsNumber == 0) {
                    pilot.setCurrentFlightPosition(PilotFlightPosition.CAPTAIN);
                    pilotsNumber++;
                } else if (pilotsNumber == 1){
                    pilot.setCurrentFlightPosition(PilotFlightPosition.COPILOT);
                    pilotsNumber++;
                }
                addCrewMember(pilot);
            } else if (employee.getEmployeeType() == EmployeeType.FLIGHTATTENDANT) {
                FlightAttendant flightAttendant = (FlightAttendant) employee;
                if (flightAttendant.getLanguageList().contains(flightLanguage)) {
                    if (flightAttendantsNumber < 3) {
                        flightCrew.add(employee);
                        flightAttendantsNumber++;
                    }
                }
            }
        }
    }

    public void setFlightLanguage() {
        HashMap<Language, Integer> languageFrequency = new HashMap<>();
        for (Passenger passenger : passengers) {
            Language language = passenger.getLanguage();
            if (languageFrequency.containsKey(language)) {
                languageFrequency.put(language, languageFrequency.get(language) + 1);
            } else {
                languageFrequency.put(language, 1);
            }
        }
        int highestNrSpeakers = 0;
        Language mostSpokenLanguage = null;
        for (Map.Entry<Language, Integer> entry : languageFrequency.entrySet()) {
            if (entry.getValue() >= highestNrSpeakers) {
                highestNrSpeakers = entry.getValue();
                mostSpokenLanguage = entry.getKey();
            }
        }
        flightLanguage = mostSpokenLanguage;
    }

    public boolean isReadyToTakeOff() {
        System.out.println("Checking Flight " + id + " conditions of clearance:");
        System.out.println("Checking if Flight has enough crew members...");
        List<Pilot> pilots = new ArrayList<>();
        List<FlightAttendant> flightAttendants = new ArrayList<>();
        for (Employee crewMember : flightCrew) {
            if (crewMember.getEmployeeType() == EmployeeType.PILOT) {
                pilots.add((Pilot) crewMember);
            } else {
                flightAttendants.add((FlightAttendant) crewMember);
            }
        }
        if (pilots.size() >= 2 && flightAttendants.size() >= 3) {
            System.out.println("Crew members passed!");
        } else {
            System.out.println("Not enough Flight crew members!");
            return false;
        }
        System.out.println("Checking if The Captain and the Co-pilot have received their Compasses...");
        for (Pilot pilot : pilots) {
            if (!pilot.hasPremiumCompass()) {
                System.out.println("Captain and Co-pilot have NOT received their Compasses!");
                return false;
            }
        }
        System.out.println("Captain and Co-pilot having Premium Compasses passed!");
        System.out.println("Checking if number of Passengers is ok...");
        if (passengers.size() >= 220) {
            System.out.println("Number of Passengers is too big!");
            return false;
        }
        System.out.println("Number of Passengers checked!");
        System.out.println("Checking if all the Flight Attendants speak the language of the flight...");
        for (FlightAttendant flightAttendant : flightAttendants) {
            if (!flightAttendant.getLanguageList().contains(flightLanguage)) {
                System.out.println("Not all Flight Attendants speak the flight language!");
                return false;
            }
        }
        System.out.println("All Flight Attendants speaking the flight language passed!");
        System.out.println("Flight" + id + "Conditions of Clearance OK!");
        return true;
    }

    public List<Employee> getFlightCrew() {
        return flightCrew;
    }

    public UUID getId() {
        return id;
    }

    public Language getFlightLanguage() {
        return flightLanguage;
    }
}
