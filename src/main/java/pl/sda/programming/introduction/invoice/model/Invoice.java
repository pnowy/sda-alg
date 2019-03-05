package pl.sda.programming.introduction.invoice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Invoice {

    private final String number;
    private final List<Item> items;
    private final Contractor contractor;

    public Invoice(String number, Contractor contractor) {
        this.number = number;
        this.contractor = contractor;
        this.items = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public List<Item> getItems() {
        return items;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public float getNetTotal() {
        float total = 0;
        for (Item item : items) {
            total += item.getNetValue();
        }
        return total;
    }

    public float getGrossTotal() {
        float total = 0;
        for (Item item : items) {
            total += item.getGrossValue();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(number, invoice.number) &&
                Objects.equals(items, invoice.items) &&
                Objects.equals(contractor, invoice.contractor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, items, contractor);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "number='" + number + '\'' +
                ", items=" + items +
                ", contractor=" + contractor +
                '}';
    }
}
