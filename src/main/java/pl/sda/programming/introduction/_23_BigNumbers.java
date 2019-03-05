package pl.sda.programming.introduction;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

final class _23_BigNumbers {

    public static void main(String[] args) {

        // factorial with BigInteger
        int n = 50;
        // how to create BigInteger
        BigInteger result = BigInteger.valueOf(1);
        // below it's equivalent
        // result = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("factorial for: %d is: %d \n", n, result);


        // BigDecimal
        BigDecimal n1 = new BigDecimal(1); // n1 is immutable
        BigDecimal n2 = n1.add(new BigDecimal(5)).subtract(new BigDecimal(10));
        System.out.println("n2 is equal " + n2.toString());

        // double, float and bid decimals
        double d1 = 0.3;
        double d2 = 0.2;
        System.out.println("Double (0.3 - 0.2) = " + (d1 - d2));

        float f1 = 0.3f;
        float f2 = 0.2f;
        System.out.println("Float (0.3 - 0.2) = " + (f1 - f2));

        BigDecimal bd1 = new BigDecimal("0.3");
        BigDecimal bd2 = new BigDecimal("0.2");
        System.out.println("BigDecimal (0.3 - 0.2) = " + bd1.subtract(bd2));

        BigDecimal bd3 = new BigDecimal(0.3).setScale(2, RoundingMode.HALF_UP);
        BigDecimal bd4 = new BigDecimal(0.2).setScale(2, RoundingMode.HALF_UP);
        System.out.println("BigDecimal with doubles (0.3 - 0.2) = "
                + bd3.subtract(bd4));

        // watch out!!!
        double d3 = 10.0;
        double d4 = 3.0;
        System.out.println("Double (10.0 / 3.0) = " + (d3 / d4));

        BigDecimal bd5 = new BigDecimal(10);
        BigDecimal bd6 = new BigDecimal(3);
        // if you not rounding you can get ArithmeticException: not-terminating decimal
        // expansion
        System.out.println("BigDecimal (10 / 3) = "
                + (bd5.divide(bd6, 10, RoundingMode.HALF_UP)));

    }
}
