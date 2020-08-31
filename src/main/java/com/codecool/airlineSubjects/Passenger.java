package com.codecool.airlineSubjects;

import com.codecool.utilities.Language;

public class Passenger {
    private final Language language;

    public Passenger(Language language) {
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }
}
