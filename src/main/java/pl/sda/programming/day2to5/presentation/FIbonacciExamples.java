package pl.sda.programming.day2to5.presentation;

import java.math.BigInteger;

public class FIbonacciExamples {

    public static void main(String[] args) {
        fibonacciRecursive(100);
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        else return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static BigInteger fibonacciIterative(int n) {
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
