package pl.sda.programming.day2to5.complexity;

import java.util.Random;

public class Utils {
    public static double nanoToMilliSeconds(long nanoSeconds) {
        return (double) nanoSeconds / 1000000;
    }

    public static Integer[] randomArray(int size) {
        Random random = new Random(System.nanoTime());
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static int[] randomIntArray(int size) {
        Random random = new Random(System.nanoTime());
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
