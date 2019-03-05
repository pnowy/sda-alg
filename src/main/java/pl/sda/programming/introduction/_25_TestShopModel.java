package pl.sda.programming.introduction;


import pl.sda.programming.introduction.shop.model.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

final class _25_TestShopModel {

    public static void main(String[] args) {
        // 1. create customer
        Customer customer = new Company("Company XWQ", "PL90392030");

        // 2. create account
        Account account = new Account(customer);
        System.out.println("Created account " + account);

        // 3. add address to customer
        Address deliveryAddress = new Address(
                "Delivery", "Dziada 4", "Dziadków", "02-400");
        customer.addAddress(deliveryAddress);
        Address contactAddress  = new Address(
                "Contact", "Pradziada 5", "Pradziadków", "03-100");
        customer.addAddress(contactAddress);

        System.out.println(customer.getAddresses());

        // 4. create discount policy
        List<String> codes = Arrays.asList("ABC123", "ABC124", "ABC125");
        DiscountPolicy couponPolicy = new CouponDiscountPolicy(0.2f, codes);

        DiscountPolicy fixedPolicy  = new FixedDiscountPolicy(0.1f);

        // 5. Add orders
        Order order1 = new Order(account, couponPolicy);
        order1.addItem(new Item("TV 1", new BigDecimal("1025.10"), 1));
        order1.addItem(new Item("Żelazko", new BigDecimal("212.65"), 3));

        System.out.println("My order 1 is: " + order1);

        Order order2 = new Order(account, fixedPolicy);
        order2.addItem(new Item("Grabki", new BigDecimal("12.45"), 5));
        order2.addItem(new Item("Widły", new BigDecimal("77.00"), 1));

        System.out.println("My order 2 is: " + order2);

        // 6. apply discount
        order1.applyDiscount("ABC123");
        order2.applyDiscount("");

        System.out.println("order 1 total: " + order1.getTotal());
        System.out.println("order 2 total: " + order2.getTotal());

        // 7. send order
        order1.sendOrder(customer.getAddresses().get(0));
        order2.sendOrder(customer.getAddresses().get(1));

        System.out.println("order 1: " + order1);
        System.out.println("order 2: " + order2);

    }
}
