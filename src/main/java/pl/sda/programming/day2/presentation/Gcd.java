package pl.sda.programming.day2.presentation;

/**
 * GDC - greatest common divisor / największy wspólny dzielnik.
 */
public class Gcd {

    public static void main(String... args) {
        System.out.println(iterativeGdc(255, 102));
        System.out.println(recursiveGcd(255, 102));
    }

    public static int iterativeGdc(int a, int b) {

        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int recursiveGcd(int a, int b) {
        int newA = a > b ? a - b : a;
        int newB = b > a ? b - a : b;
        return a == b ? a : recursiveGcd(newA, newB);
    }
}
