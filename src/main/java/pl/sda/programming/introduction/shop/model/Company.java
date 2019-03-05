package pl.sda.programming.introduction.shop.model;

import java.util.Objects;

public final class Company extends Customer {

    private final String name;
    private final String vatNumber;

    public Company(String name, String vatNumber) {
        this.name = name;
        this.vatNumber = vatNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(vatNumber, company.vatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vatNumber);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                '}';
    }
}
