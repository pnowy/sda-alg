package pl.sda.programming.introduction.invoice.model;

import java.util.Objects;

public class Item {

    private final String name;
    private final float netValue;
    private final float tax;

    public Item(String name, float netValue, float tax) {
        this.name = name;
        this.netValue = netValue;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public float getNetValue() {
        return netValue;
    }

    public float getTax() {
        return tax;
    }

    public float getGrossValue() {
        return netValue + (netValue * tax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Float.compare(item.netValue, netValue) == 0 &&
                Float.compare(item.tax, tax) == 0 &&
                Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, netValue, tax);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", netValue=" + netValue +
                ", tax=" + tax +
                '}';
    }
}
