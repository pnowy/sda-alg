package pl.sda.programming.day2to5.datastructures.domain;

import java.util.Objects;

public class Patient {
    private final Pesel pesel;
    private final String name;

    public Patient(Pesel pesel, String name) {
        this.pesel = pesel;
        this.name = name;
    }

    public Pesel getPesel() {
        return pesel;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return pesel.equals(patient.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }
}
