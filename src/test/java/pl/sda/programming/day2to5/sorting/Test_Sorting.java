package pl.sda.programming.day2to5.sorting;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Test_Sorting {
    private static final Logger log = LoggerFactory.getLogger(Test_Sorting.class);

    private Solutions_Sorting sorting = new Solutions_Sorting();

    @Test

    void innerLoopExplanation() {
        int sizeArray = 5;
        for (int i = 0; i < sizeArray; i++) {
            log.info("External loop: i={}", i);
            for (int j = 0; j < sizeArray; j++) {
                log.info("\tInternal loop: i={}, j={}", i, j);
            }
        }
    }

    @Test
    void bubbleSortExample() {
        int[] array = {3, 42, 7, 19};
        sorting.bubbleSort(array);
        log.info("Bubble sort result={}", array);
    }

    @Test
    void selectionSortExample() {
        int[] array = {3, 42, 7, 19};
        sorting.selectionSort(array);
        log.info("Selection sort result={}", array);
    }

    @Test
    void insertionSortExample() {
        int[] array = {5, 3, 4};
        sorting.insertionSort(array);
        log.info("Insertion sort result={}", array);
    }

    @Test
    void quickSortExample() {
        int[] array = { 25, 11, 5, 99, 13 };
        sorting.quickSort(array);
        log.info("Quick sort result={}", array);
    }

    @Test
    void mergeSortExample() {
        int[] array = { 25, 11, 5, 99, 13 };
        sorting.mergeSort(array);
        log.info("Merge sort result={}", array);
    }

}
