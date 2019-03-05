package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Address;
import pl.sda.programming.introduction.shop.model.Order;
import pl.sda.programming.introduction.shop.model.OrderStatus;
import pl.sda.programming.introduction.shop.utils.OptionSelector;

import java.util.List;
import java.util.Scanner;

final class SendOrderMenuCommand implements MenuCommand<Order> {
    @Override
    public String getText() {
        return "Send order to customer";
    }

    @Override
    public void execute(Order order) {
        if (order.getStatus().equals(OrderStatus.SENT)) {
            System.out.println("Order already sent!");
            return;
        }
        Address address = getAddress(order);
        order.sendOrder(address);
        System.out.println("Order send correctly to customer!");
    }

    private Address getAddress(Order order) {
        List<Address> addresses = order.getAccount().getCustomer().getAddresses();
        Address address;
        if (addresses.isEmpty()) {
            address = createNewAddress(order);
        } else {
            address = selectAddress(addresses);
        }
        return address;
    }

    private Address selectAddress(List<Address> addresses) {
        Address address;
        System.out.println("Please select address from list:");
        int option = new OptionSelector<>(addresses).select();
        address = addresses.get(option - 1);
        return address;
    }

    private Address createNewAddress(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("No address assigned to customer.\nPlease create new address.");
        System.out.println("Address name:");
        String name = scanner.nextLine();
        System.out.println("Address street:");
        String street = scanner.nextLine();
        System.out.println("Address postcode:");
        String postcode = scanner.nextLine();
        System.out.println("Address city:");
        String city = scanner.nextLine();

        Address address = new Address(name, street, postcode, city);
        order.getAccount().getCustomer().addAddress(address);
        return address;
    }
}
