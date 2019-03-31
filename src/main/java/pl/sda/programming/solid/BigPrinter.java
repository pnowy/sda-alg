package pl.sda.programming.solid;

import java.util.Arrays;
import java.util.List;

public class BigPrinter implements Printer {
    private List<PrintingStrategy> printingStrategies;

    public BigPrinter(PrintingStrategy... printingStrategies) {
        this.printingStrategies = Arrays.asList(printingStrategies);
    }


    @Override
    public void printPages() {
        printingStrategies.forEach(PrintingStrategy::print);
    }
}
