package pl.sda.programming.day1;

import java.util.Scanner;

class Task1 {

    /**
     * Napisz program który obliczy sumę dwóch liczb liczb podanych przez użytkownika
     *  - w konsoli
     *  - jako argumenty wejściowe programu
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give me the first number");
        int a = scanner.nextInt();
        System.out.println("Please give me the first number");
        int b = scanner.nextInt();
        int sum = a + b;
        System.out.println("The sum of " + a + " and " + b + " is " + sum);
    }
}
