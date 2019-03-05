package pl.sda.programming.introduction.shop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Customer implements Serializable {

    private final List<Address> addresses;

    // protected means: it will be visible only for subclasses
    protected Customer() {
        addresses = new ArrayList<>();
    }

    public abstract String getName();

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }
}
