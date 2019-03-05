package pl.sda.programming.introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

final class _17_ScannerListMinMax {

    public static void main(String[] args) {
        // initialize array list of integers
        List<Integer> numbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // in loop get numbers from user and add to "numbers" list
        // ........
        int number;
        do {
            System.out.println("Please provide next number:");
            number = scanner.nextInt();
            if (number != 0) {
                numbers.add(number);
            }
        } while (number != 0);

        // when user provide 0 loop ends

        // find min and max from numbers list and print
        System.out.println("MIN: " + Collections.min(numbers));
        System.out.println("MAX: " + Collections.max(numbers));
    }
}
