package pl.sda.programming.day1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

class Task5 {

    /**
     * Napisz program który sprawdzi czy osoba jest pełnoletnia.
     * Program powinien wczytać z konsoli datę urodzenia w formacie dd.MM.yyyy i powiedzieć czy osoba jest pełnoletnia czy nie.
     * Jak zamienić String na Date?
     */
    public static void main(String[] args) {
        System.out.println("Please enter your birth day in the format: yyyy.MM.dd (ex. 1999.12.15)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        try {
            Date date = format.parse(input);
            LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            // computing age taken from https://stackoverflow.com/questions/1116123/how-do-i-calculate-someones-age-in-java
            int years = Period.between(birthDate, LocalDate.now()).getYears();
            System.out.println("You are " + years + " old");
            if (years >= 18) {
                System.out.println("You're an adult");
            } else {
                System.out.println("You're not an adult");
            }
        } catch (ParseException e) {
            System.out.println("I could not understand that, you sure \"" + input + "\" is in valid date?");
            System.out.println("I'll let you try again");
            main(args); // we can call main recursive
        }
    }
}
