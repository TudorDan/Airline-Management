package com.codecool.airlinePersons;

import com.codecool.utilities.Language;

public class Passenger {
    private final Language preferredLanguage;

    public Passenger(Language language) {
        this.preferredLanguage = language;
    }

    public Language getPreferredLanguage() {
        return preferredLanguage;
    }
}
