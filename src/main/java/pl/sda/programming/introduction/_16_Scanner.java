package pl.sda.programming.introduction;

import java.util.Scanner;

final class _16_Scanner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide text:");
        String choice = scanner.next();

        System.out.println(choice.toUpperCase());

        System.out.println("Please provide number: ");
        int i1 = scanner.nextInt();
        switch (i1) {
            case 0:
                System.out.println("your value is 0");
                break;
            case 2:
                System.out.println("your value is 2");
                break;
            default:
                System.out.println("your value is " + i1);
        }
    }
}
