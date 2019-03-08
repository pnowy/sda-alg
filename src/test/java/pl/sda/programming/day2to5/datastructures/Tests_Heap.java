package pl.sda.programming.day2to5.datastructures;

import org.junit.jupiter.api.Test;
import pl.sda.programming.day2to5.datastructures.solutions.Solutions_Heap;
import pl.sda.programming.day2to5.datastructures.tasks.SdaHeap;
import pl.sda.programming.day2to5.datastructures.tasks.Tasks_Heap;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class Tests_Heap {

    private Tasks_Heap exercises = new Solutions_Heap();

    @Test
    void test_isHeap() {
        assertTrue(exercises.isHeap(new int[]{9, 8, 7, 6, 5, 4, 3}));
        assertTrue(exercises.isHeap(new int[]{9, 8, 7, 6, 5, 4, 3, 2}));
        assertFalse(exercises.isHeap(new int[]{0, 1, 2, 0, 4, 5, 6, 7, 8, 9}));
        assertTrue(exercises.isHeap(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        assertFalse(exercises.isHeap(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 10}));
        assertFalse(exercises.isHeap(new int[]{5, 5, 5, 6, 6, 6, 6, 7, 7, 1}));
        assertTrue(exercises.isHeap(new int[]{9, 3, 9, 2, 1, 6, 7, 1, 2, 1}));
        assertFalse(exercises.isHeap(new int[]{8, 7, 6, 1, 2, 3, 4, 2, 1, 2}));
        assertTrue(exercises.isHeap(new int[]{10}));
        assertTrue(exercises.isHeap(new int[]{10, 8}));
        assertTrue(exercises.isHeap(new int[0]));
    }

    @Test
    void test_SdaHeap_push() {
        SdaHeap<Integer> heap = exercises.createHeap(new Integer[]{9, 8, 7, 6, 5, 4, 3}, 15);
        heap.push(1);
        assertArrayEquals(new Integer[]{9, 8, 7, 6, 5, 4, 3, 1}, heap.toArray());
        heap.push(6);
        assertArrayEquals(new Integer[]{9, 8, 7, 6, 5, 4, 3, 1, 6}, heap.toArray());
        heap.push(8);
        assertArrayEquals(new Integer[]{9, 8, 7, 6, 8, 4, 3, 1, 6, 5}, heap.toArray());
        heap.push(10);
        assertArrayEquals(new Integer[]{10, 9, 7, 6, 8, 4, 3, 1, 6, 5, 8}, heap.toArray());
        assertEquals(11, heap.size());

        assertThrows(IllegalStateException.class, () -> exercises.createHeap(new Integer[]{5, 4, 3, 2}, 4).push(9));
    }

    @Test
    void test_SdaHeap_pop() {
        SdaHeap<Integer> heap = exercises.createHeap(new Integer[]{9, 3, 9, 2, 1, 6, 7, 1, 2, 1}, 15);
        assertEquals(9, (int) heap.pop());
        assertEquals(9, (int) heap.pop());
        assertEquals(7, (int) heap.pop());
        assertEquals(6, (int) heap.pop());
        assertEquals(6, heap.size());
        assertEquals(3, (int) heap.pop());
        assertEquals(2, (int) heap.pop());
        assertEquals(2, (int) heap.pop());
        assertEquals(1, (int) heap.pop());
        assertEquals(1, (int) heap.pop());
        assertEquals(1, (int) heap.pop());
        assertEquals(0, heap.size());
        assertThrows(NoSuchElementException.class, heap::pop);
    }

}
