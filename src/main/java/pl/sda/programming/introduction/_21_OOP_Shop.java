package pl.sda.programming.introduction;


import pl.sda.programming.introduction.shop.model.*;

import java.util.Arrays;
import java.util.List;

final class _21_OOP_Shop {

    public static void main(String[] args) {
        // you cannot create objects from abstract classes
        // Customer customer = new Customer();

        // create customers
        Customer person  = new Person("Jan", "Kowalski");
        Customer company = new Company("XYZ Sp. z o.o.", "VAT83383838");

        List<Customer> customers = Arrays.asList(person, company);
        for (Customer customer : customers) {
            System.out.println(customer.getName());
            System.out.println(customer);
        }

        if (person instanceof Person) {
            Person person1 = (Person) person;
            System.out.println("Person first name: " + person1.getFirstName());

            person1.setFirstName("Dawid");
            System.out.println("person  is " + person);
            System.out.println("person1 is " + person1);
        }

        if (company instanceof Company) {
            Company cmp = (Company) company;
            System.out.println("Company vat number: " + cmp.getVatNumber());
        }

        // add addresses
        person.addAddress(new Address("Delivery", "Street 1", "City 1", "01-200"));
        person.addAddress(new Address("Delivery 2", "Street 2", "City 1", "01-500"));

        company.addAddress(new Address("Delivery", "Cmp Street 1", "Cpm City 1", "11-222"));

        System.out.println("person " + person.getAddresses());
        System.out.println("company " + company.getAddresses());

        // print addresses in loop
        for (Address address : person.getAddresses()) {
            System.out.println(address);
        }

        // get by index
        System.out.println("Address: " + person.getAddresses().get(0));


        // create account
        Account personAccount  = new Account(person);
        Account companyAccount = new Account(company);

        Customer c1 = personAccount.getCustomer();
        if (c1 instanceof Company) {
            Company cmp2 = (Company) c1;
            System.out.println("Is company: " + cmp2.getVatNumber());
        } else if (c1 instanceof Person) {
            Person person1 = (Person) c1;
            System.out.println("Is person: " + person1.getLastName());
        }
    }
}
