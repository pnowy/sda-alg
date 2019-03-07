package pl.sda.programming.day2to5.tasks;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class FixedSizeSdaHeap<T extends Comparable<T>> implements SdaHeap<T> {

    private T[] heap;
    private int size;

    // zakładamy, że "heap" jest poprawnym kopcem
    public FixedSizeSdaHeap(T[] heap, int capacity) {
        this.heap = Arrays.copyOf(heap, capacity);
        this.size = heap.length;
    }

    @Override
    public void push(T element) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap full");
        }
        heap[size] = element;
        siftUp(size);
        size++;
    }

    private void siftUp(int i) {
        if (i == 0) {
            return;
        }
        int parent = (i - 1) / 2;
        if (heap[parent].compareTo(heap[i]) < 0) {
            swap(parent, i);
            siftUp(parent);
        }
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Heap empty");
        }
        T result = heap[0];
        heap[0] = null;
        size--;
        swap(0, size);
        siftDown(0);
        return result;
    }

    private void siftDown(int i) {
        int largest = i;

        int left = 2 * i + 1;
        if (left < heap.length && heap[left] != null && heap[left].compareTo(heap[largest]) > 0) {
            largest = left;
        }

        int right = 2 * i + 2;
        if (right < heap.length && heap[right] != null && heap[right].compareTo(heap[largest]) > 0) {
            largest = right;
        }

        if (i != largest) {
            swap(i, largest);
            siftDown(largest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @Override
    public int size() {
        return size;
    }

    public T[] toArray() {
        return Arrays.copyOf(heap, size);
    }

}
