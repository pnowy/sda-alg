package pl.sda.programming.introduction.invoice.model;

import java.util.Objects;

public class Contractor {

    private final String name;
    private final String vatNumber;
    private final String regon;
    private final String nip;

    public Contractor(String name, String vatNumber, String regon, String nip) {
        this.name = name;
        this.vatNumber = vatNumber;
        this.regon = regon;
        this.nip = nip;
    }

    public String getName() {
        return name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getRegon() {
        return regon;
    }

    public String getNip() {
        return nip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contractor that = (Contractor) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(vatNumber, that.vatNumber) &&
                Objects.equals(regon, that.regon) &&
                Objects.equals(nip, that.nip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vatNumber, regon, nip);
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "name='" + name + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", regon='" + regon + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }
}
