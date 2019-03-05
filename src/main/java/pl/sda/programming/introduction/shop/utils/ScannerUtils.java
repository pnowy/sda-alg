package pl.sda.programming.introduction.shop.utils;

import java.util.Scanner;

public final class ScannerUtils {

    public static int nextInt(int from, int to) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int selection = scanner.nextInt();
            if (selection >= from && selection <= to) {
                return selection;
            }
            System.out.printf(
                    "Invalid option. Please select one between %d and %d\n",
                    from, to);
        }
    }
}
