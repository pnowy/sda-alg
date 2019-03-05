package pl.sda.programming.introduction;

import java.util.Arrays;
import java.util.Random;

final class _13_Arrays {

    public static void main(String[] args) {

        // arrays are indexed from 0
        // store values of the same type

        int[] arr1 = new int[10];
        int i1 = arr1[0];
        System.out.println("arr1[0] = " + i1);

        arr1[0] = 1;
        i1 = arr1[0];
        System.out.println("arr1[0] = " + arr1[0]);

        arr1[1] = 2;
        arr1[2] = 5;
        arr1[3] = 15;

        // what if index is out of bounds??
        // arr1[-1] = 10; don't do that, be careful ! it will crash your program

        arr1 = new int[50];

        // initialize array with values
        String[] stringArray = new String[] { "zdisiek", "kamil", "michał", "marcin" };

        System.out.println(Arrays.toString(stringArray));

        // sort array
        Arrays.sort(stringArray);
        System.out.println("sorted " + stringArray);

        String[] test = stringArray;
        System.out.println("test arr: " + Arrays.toString(stringArray));
        test[0] = "uuuuuuu";
        System.out.println("string array: " + Arrays.toString(stringArray));
        System.out.println("test array: " + Arrays.toString(test));

        // you can use Arrays.copyOf()
        String[] copy = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            copy[i] = stringArray[i];
        }
        copy[0] = "ttttttt";
        System.out.println("string array: " + Arrays.toString(stringArray));
        System.out.println("copy array: " + Arrays.toString(copy));

        System.out.println(Arrays.toString(stringArray));

        // print via loop
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("name is " + stringArray[i]);
        }

        // for - enhanced for
        for (String name : stringArray) {
            System.out.print(name + ", ");
        }

        System.out.println();

        // sum array elements
        Random random = new Random();
        double elements[] = new double[5];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = random.nextDouble();
        }
        System.out.println("randoms " + Arrays.toString(elements));

        // calculate average
        double sum = 0.0;
        for (double element : elements) {
            sum += element;
        }
        double average = sum / elements.length;
        System.out.println("Average is " + average);

        // Sito Eratostenesa
        int n = 100;
        boolean[] primes = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                continue; // go for next: i
            }
            for (int j = i * i; j < n; j += i) {
                primes[j] = true;
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();

        System.out.println("is 3 prime number? " + !primes[3]);



        // multi dimensional arrays
        int[][] multi = new int[10][];

        multi[0] = new int[10];
        multi[1] = new int[5];

        multi[0][0] = 1;

        for (int i = 0; i < multi.length; i++) {
            multi[i] = new int[10];
            for (int j = 0; j < multi[i].length; j++) {
                multi[i][j] = random.nextInt(100);
            }
        }

        for (int i = 0; i < multi.length; i++) {
            System.out.println(Arrays.toString(multi[i]));
        }

        System.out.println("element in [0, 9]: " + multi[0][9]);

        // fill in loop and print
        /*   1   2   3   4   5
             2   4   6   8   10
             3   6   9   12  15
             4   8   12  16  20
             5   10  15  20  25
        */
        int[][] values = new int[5][5];

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int i = 0; i < values.length; i++) {
            System.out.println(Arrays.toString(values[i]));
        }

    }
}
