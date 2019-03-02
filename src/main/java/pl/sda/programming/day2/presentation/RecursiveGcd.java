package pl.sda.programming.day2.presentation;

public class RecursiveGcd {

    public static void main(String... args) {
        gcd(255, 102);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
