package pl.sda.programming.day1;

public class Task8 {

    /**
     * Napisz program który wyświetli kwadrat z znaków * o boku 3
     * ***
     * * *
     * ***
     * 1. Zmodyfikuj program tak by długość boku była wczytywana z wejścia
     */
    public static void main(String[] args) {

        System.out.println("***");
        System.out.println("* *");
        System.out.println("***");

        System.out.println(asteriskSquare(3));
        System.out.println(asteriskSquare(4));
        System.out.println(asteriskSquare2(4));
        System.out.println(asteriskSquare3(4));
    }

    public static String asteriskSquare(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += "*";
        }
        result += "\n";
        for (int i = 0; i < length - 2; i++) {
            result += "*";
            for (int j = 0; j < length - 2; j++) {
                result += " ";
            }
            result += "*";
            result += "\n";
        }
        for (int i = 0; i < length; i++) {
            result += "*";
        }
        return result;
    }

    // lets refactor
    public static String asteriskSquare2(int length) {
        String result = "";
        result = repeat(length, "*");
        result += "\n";
        for (int i = 0; i < length - 2; i++) {
            result += "*";
            result += repeat(length - 2, " ");
            result += "*";
            result += "\n";
        }
        result += repeat(length, "*");
        return result;
    }

    private static String repeat(int length, String character) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += character;
        }
        return result;
    }

    // even better - StringBuilder is the preferred way of concatenating strings
    public static String asteriskSquare3(int length) {
        StringBuilder result = new StringBuilder();
        result.append(repeat(length, "*"));
        result.append("\n");
        for (int i = 0; i < length - 2; i++) {
            result.append("*");
            result.append(repeat(length - 2, " "));
            result.append("*");
            result.append("\n");
        }
        result.append(repeat(length, "*"));
        return result.toString();
    }

}
