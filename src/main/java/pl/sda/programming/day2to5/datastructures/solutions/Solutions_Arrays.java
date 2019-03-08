package pl.sda.programming.day2to5.datastructures.solutions;

import pl.sda.programming.day2to5.datastructures.tasks.Tasks_Arrays;

import java.util.Arrays;
import java.util.Random;

public class Solutions_Arrays implements Tasks_Arrays {

    @Override
    public int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double avg(int[] array) {
        double sum = 0;
        for (int val : array) sum = sum + val;
        return sum / array.length;
    }

    @Override
    public int random(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
        }
        return Arrays.stream(array).sum();
    }

}
