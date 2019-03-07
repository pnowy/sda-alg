package pl.sda.programming.day2to5.solutions;

import pl.sda.programming.day2to5.tasks.FixedSizeSdaHeap;
import pl.sda.programming.day2to5.tasks.SdaHeap;
import pl.sda.programming.day2to5.tasks.Tasks_Heap;

public class Solutions_Heap implements Tasks_Heap {

    @Override
    public boolean isHeap(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (array[left] > array[i] || (right < array.length && array[right] > array[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public <T extends Comparable<T>> SdaHeap<T> createHeap(T[] heap, int capacity) {
        return new FixedSizeSdaHeap<>(heap, capacity);
    }

}
