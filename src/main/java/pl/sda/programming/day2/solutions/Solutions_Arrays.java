package pl.sda.programming.day2.solutions;

import pl.sda.programming.day2.tasks.Tasks_Arrays;

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
    public double random(int size) {
        return 0;
    }

}
