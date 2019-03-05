package pl.sda.programming.introduction.invoice.util;

import pl.sda.programming.introduction.invoice.model.Contractor;
import pl.sda.programming.introduction.invoice.model.Invoice;

import java.util.ArrayList;
import java.util.List;

public final class InvoiceUtil {

    public static List<Invoice> findByContractor(Contractor contractor, List<Invoice> invoices) {
        List<Invoice> result = new ArrayList<>();
        for (Invoice invoice : invoices) {
            if (invoice.getContractor().equals(contractor)) {
                result.add(invoice);
            }
        }
        return result;
    }

    public static List<Invoice> findByNumberStartingWith(String number, List<Invoice> invoices) {
        List<Invoice> result = new ArrayList<>();
        for (Invoice invoice : invoices) {
            if (invoice.getNumber().startsWith(number)) {
                result.add(invoice);
            }
        }
        return result;
    }

    public static Invoice getWithHigherGrossValue(Invoice i1, Invoice i2) {
        return i1.getGrossTotal() >= i2.getGrossTotal() ? i1 : i2;
    }

    public static int countItems(List<Invoice> invoices) {
        int total = 0;
        for (Invoice invoice : invoices) {
            total += invoice.getItems().size();
        }
        return total;
    }
}
