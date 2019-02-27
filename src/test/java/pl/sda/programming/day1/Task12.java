package pl.sda.programming.day1;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class Task12 {

    /**
     * Do programu wypisującego ciąg liczb fibonacciego dodaj wypisywanie liczb ciągu w postaci binarnej
     */
    @Test
    void task() {
        BigInteger current = BigInteger.ONE;
        BigInteger previous;
        int length = 80;
        for (int i = 0; i < 70; i++) {
            previous = current;
            current = fibonacci_iterative(i);
            String format = String.format("|%4d|%50d|%" + length + "s|",
                    i,
                    current,
                    toBinary(current, length));
            System.out.println(format);
        }
        // using int I can print 44 fibonacci numbers
        // using long I can print 90 fibonacci numbers
        // using BigInteger I printed 10000 fibonacci numbers and could probably print many more
    }

    private static String toBinary(BigInteger number, int feedZerosCount) {
        String result = "";
        for (int i = 0; i < feedZerosCount; i++) {
            if (number.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                result = "1" + result;
            } else {
                result = "0" + result;
            }
            number = number.divide(BigInteger.valueOf(2));
        }

        return result;

    }

    public static int fibonacci(int i) {
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            return 1;
        } else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }

    public static BigInteger fibonacci_iterative(int i) {
        if (i == 0) {
            return BigInteger.ONE;
        } else if (i == 1) {
            return BigInteger.ONE;
        } else {
            BigInteger a = BigInteger.ONE;
            BigInteger b = BigInteger.ONE;
            BigInteger temp;
            for (int j = 0; j < i; j++) {
                temp = a.add(b);
                a = b;
                b = temp;
            }
            return b;
        }
    }
}
