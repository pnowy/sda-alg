package pl.sda.programming.day1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class Task10 {

    /**
     * Napisz program który wyświetli N elementów ciągu fibonacciego
     * - Do każdego wypisanego elementu wypisz jego stosunek do poprzedniego elementu ( poprzedni / aktualny )
     * - Ile elementów ciągu jesteś w stanie obliczyć używając zmiennych typu int? long? BigInteger?
     */
    @Test
    void task() {
        BigInteger current = BigInteger.ONE;
        BigInteger previous;
        for (int i = 0; i < 50; i++) {
            previous = current;
            current = fibonacci_iterative(i);
            double ratio = previous.doubleValue() / current.doubleValue();
            String format = String.format("|%4d|%100d|%23.20f|", i, current, ratio);
            System.out.println(format);
        }
        // using int I can print 44 fibonacci numbers
        // using long I can print 90 fibonacci numbers
        // using BigInteger I printed 10000 fibonacci numbers and could probably print many more

    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static BigInteger fibonacci_iterative(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        } else {
            BigInteger fib = BigInteger.ONE;
            BigInteger prevFib = BigInteger.ONE;
            BigInteger temp;
            for (int i = 2; i < n; i++) {
                temp = fib;
                fib = fib.add(prevFib);
                prevFib = temp;
            }
            return fib;
        }
    }

}
