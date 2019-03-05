package pl.sda.programming.introduction;

final class _11_Loops {

    public static void main(String[] args) {
        // while loop
        int sum = 0;
        while (sum < 100) {
            sum += 10;
        }
        System.out.println("sum is " + sum);

        sum = 105;
        while (sum < 100) {
            sum += 10;
        }
        System.out.println("sum is " + sum);

        // do ... while
        sum = 105;
        do {
            sum += 10;
        } while (sum < 100);
        System.out.println("do while sum is " + sum);

        // infinity loop/break
        sum = 0;
        while (true) {
            System.out.println("sum is " + sum);
            sum++;
            if (sum == 10000) {
                break; // break the while loop
            }
        }
        System.out.println("sum is " + sum);

        // infinity for loop
//        for ( ; ; ) {
//
//        }

        // for loop
        int result = 10;
        for (int i = 0; i < 100; i++) {
            result += i * i;
        }
        System.out.println("result is " + result);

        // factorial = 1 * 2 * 3 * ... n
        int n = 20; // watch out for big numbers!!
        result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i; // result = result * i
        }
        System.out.printf("factorial for: %d is: %d \n", n, result);

        // factorial with wile
        result = 1;
        int j = 1;
        while (j <= n) {
            result *= j;
            j++;
        }
        System.out.printf("factorial while: %d is: %d \n", n, result);

        // fibonacci
        n = 19;
        int n1 = 0, n2 = 1;
        result = 0;
        for (int i = 2; i <= n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        System.out.println("fibonacci is: " + result);

        // prime numbers
        // n = 100;
        // iteruj od i = 2 do i <= n
        //       licznik = 0;
        //       szukaj podzielnikow dla i:
        //       iteruj: k = i; j >= 2; j--
        //          jesli i % k == 0
        //             zwieksz licznik o 1
        //       jesli licznik < 2 to jest to liczba pierwsza
        StringBuilder builder = new StringBuilder();
        n = 100;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int k = i; k >= 2; k--) {
                if (i % k == 0) {
                    count++;
                    if (count == 2) {
                        break;
                    }
                }
            }
            if (count < 2) {
                builder.append(i).append(',');
            }
        }
        System.out.println("prime number is " +
                builder.substring(0, builder.length() - 1));
    }
}
