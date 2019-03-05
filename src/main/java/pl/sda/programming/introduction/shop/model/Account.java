package pl.sda.programming.introduction.shop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account implements Serializable {

    private final Customer customer;
    private final List<Order> orders;

    public Account(Customer customer) {
        this.customer = customer;
        this.orders = new ArrayList<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(customer, account.customer) &&
                Objects.equals(orders, account.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, orders);
    }

    @Override
    public String toString() {
        return "Account{" +
                "customer=" + customer +
                "orders number=" + orders.size() +
                '}';
    }
}
