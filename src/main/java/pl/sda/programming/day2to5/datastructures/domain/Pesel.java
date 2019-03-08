package pl.sda.programming.day2to5.datastructures.domain;

import java.util.Objects;

public class Pesel {
    private final String value;

    public Pesel(String value) {
        this.value = Objects.requireNonNull(value, "Pesel value cannot be null");
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pesel pesel = (Pesel) o;
        return value.equals(pesel.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
