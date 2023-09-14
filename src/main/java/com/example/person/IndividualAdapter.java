package com.example.person;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class IndividualAdapter extends Person {

    private final String[] names;
    private final Date dateOfBirth;

    public IndividualAdapter(Individual individual) {
        names = individual.getFullName().split(", ");
        dateOfBirth = individual.getDateOfBirth();
    }

    @Override
    public String getFirstName() {
        return names[1];
    }

    @Override
    public String getLastName() {
        return names[0];
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
