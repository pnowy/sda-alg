package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Account;
import pl.sda.programming.introduction.shop.model.Address;

import java.util.Scanner;

final class CreateAddressMenuCommand implements MenuCommand<Account> {
    @Override
    public String getText() {
        return "Create new address";
    }

    @Override
    public void execute(Account account) {
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
        account.getCustomer().addAddress(address);
        System.out.println("New address created: " + address);
    }
}
