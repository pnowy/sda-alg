package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Account;
import pl.sda.programming.introduction.shop.model.Company;
import pl.sda.programming.introduction.shop.model.Customer;
import pl.sda.programming.introduction.shop.model.Person;
import pl.sda.programming.introduction.shop.utils.OptionSelector;

import java.util.List;
import java.util.Scanner;

final class CreateAccountMenuCommand implements MenuCommand<List<Account>> {

    private static final OptionSelector<String> TYPES =
            new OptionSelector<>("Person", "Company");

    @Override
    public String getText() {
        return "Create new account";
    }

    @Override
    public void execute(List<Account> accounts) {
        System.out.println(
                "You are creating new account. " +
                "Please select account type:");
        int type = TYPES.select();
        Customer customer;
        switch (type) {
            case 1:
                customer = createPerson();
                break;
            case 2:
                customer = createCompany();
                break;
            default:
                System.out.println("Wrong option. It's developer bug!!");
                return;
        }
        accounts.add(new Account(customer));
        System.out.println("Account created for customer: " + customer.getName());
    }

    private Customer createCompany() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type name:");
        String name = scanner.nextLine();
        System.out.println("Please type VAT number");
        String vatNumber = scanner.next();
        return new Company(name, vatNumber);
    }

    private Customer createPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type first name:");
        String firstName = scanner.next();
        System.out.println("Please type last name:");
        String lastName  = scanner.next();
        return new Person(firstName, lastName);
    }
}
