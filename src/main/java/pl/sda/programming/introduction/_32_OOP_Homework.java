package pl.sda.programming.introduction;

import pl.sda.programming.introduction.invoice.model.Contractor;
import pl.sda.programming.introduction.invoice.model.Invoice;
import pl.sda.programming.introduction.invoice.model.Item;
import pl.sda.programming.introduction.invoice.util.InvoiceUtil;

import java.util.Arrays;
import java.util.List;

final class _32_OOP_Homework {
    public static void main(String[] args) {

        Contractor contractor1 = new Contractor("Jan Kowalski", "PL9292992", "33394949", "8938838");
        Contractor contractor2 = new Contractor("Adam Nowak", "PL83993", "938883", "929383");

        Invoice invoice1 = new Invoice("112", contractor1);
        Invoice invoice2 = new Invoice("113", contractor2);
        Invoice invoice3 = new Invoice("221", contractor1);

        invoice1.addItem(new Item("Product 1", 10.00f, .23f));
        invoice1.addItem(new Item("Product 2", 23.10f, .23f));

        invoice2.addItem(new Item("Service 1", 500.00f, .23f));
        invoice2.addItem(new Item("Service 2", 120.90f, .08f));

        invoice3.addItem(new Item("Product 3", 70.90f, .23f));

        // let's test
        System.out.printf("gross value invoice2: %.2f\n", invoice2.getGrossTotal());

        List<Invoice> invoices = Arrays.asList(invoice1, invoice2, invoice3);
        List<Invoice> result = InvoiceUtil
                .findByContractor(contractor1, invoices);
        System.out.println("find by contractor " + result);

        result = InvoiceUtil.findByNumberStartingWith("11", invoices);
        System.out.println("find by number " + result);

        Invoice invoice = InvoiceUtil.getWithHigherGrossValue(invoice3, invoice2);
        System.out.println("with higher gross total " + invoice);

        int countItems = InvoiceUtil.countItems(invoices);
        System.out.println("count items " + countItems);
    }
}
