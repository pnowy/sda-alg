package pl.sda.programming.day1;

import org.junit.jupiter.api.Test;

class Task4 {

    /**
     * Napisz program który wypisze od tyłu tekst podany na wejściu konsoli. czyli "programuje w javie" -> "eivaj w ejumargorp"
     */
    @Test
    void task() {
        System.out.println("Some tests first:");
        System.out.println(reverse("this is a test"));
        System.out.println(reverse("I'm so good at java"));
        System.out.println(reverse("So good to be bad"));
        System.out.println(reverse("You know the rules"));
        System.out.println(reverse("And so do I"));

        System.out.println(reverse2("this is a test"));
        System.out.println(reverse2("I'm so good at java"));
        System.out.println(reverse2("So good to be bad"));
        System.out.println(reverse2("You know the rules"));
        System.out.println(reverse2("And so do I"));
    }

    public static String reverse(String input) {
        int length = input.length();
        char[] reversed = new char[length];
        for (int i = 0; i < length; i++) {
            reversed[length - i - 1] = input.charAt(i);
        }
        return new String(reversed);
    }

    public static String reverse2(String input) {
        StringBuilder builder = new StringBuilder(input);
        return builder.reverse().toString();
    }
}
