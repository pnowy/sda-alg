package pl.sda.programming.solid;

public class StrategyExample {
    public static void main(String[] args) {
        Printer bigPrinter = new BigPrinter(new A5Printing(), new A3Printing(), new A4Printing());
        Printer smallPrinter = new SmallPrinter(new A4Printing());

        bigPrinter.printPages();
        System.out.println("----");
        smallPrinter.printPages();
    }
}
