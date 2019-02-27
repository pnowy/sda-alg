package pl.sda.programming.day1;

import java.util.Scanner;

class Task6 {

    /**
     * Napisz program który wczyta tekst i wypisze go używając wyłącznie wielkich liter.
     *
     * Zmodyfikuj program tak by po wypisaniu wejściu pozwolił wprowadzić kolejne słowa dopóki użytkownik nie poda "q!"
     * Poniższe punkty wymagają zrozumienia kodowania znaków ASCII
     * Java: Napisz program bez użycia String.toUpperCase() oraz bez uzycia Character.toUpperCase()
     */
    public static void main(String[] args) {
        System.out.println("Some tests:");
        test("tekst");
        test("to jest test");
        test("co tam słychać");
        test("whattttttts up?");

        // another solution:
        // I didn't know String class has a toUpperCase() method :)
        System.out.println("myText".toUpperCase());

        System.out.println("Give me some text and I'll upper case it:");
        System.out.println("Input 'q!' to exit");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if(input.equals("q!")) {
                break;
            }
            System.out.println(input.toUpperCase());
        }
        System.out.println("exiting...");
    }

    private static void test(String input) {
        System.out.println("input: " + input);
        System.out.println("to upper case: " + toUpperCase(input));
    }

    public static String toUpperCase(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = Character.toUpperCase(chars[i]);
        }
        return new String(chars);
    }

    private static String toUpperUsingAsciiCodes(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('a' <= chars[i] && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32); // 32 = 'a' - 'A'
            }
        }
        return new String(chars);
    }

}
