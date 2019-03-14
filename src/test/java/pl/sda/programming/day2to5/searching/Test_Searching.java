package pl.sda.programming.day2to5.searching;

import org.junit.jupiter.api.Test;
import pl.sda.programming.day2to5.searching.Task_Searching.IntRange;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Comparator.naturalOrder;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Test_Searching {

    private Task_Searching searching = new Solutions_Searching();

    @Test
    void test_linearSearch() {
        int[] array = {5, 2, 9, 10, -43};
        assertEquals(0, searching.linearSearch(array, 5));
        assertEquals(1, searching.linearSearch(array, 2));
        assertEquals(2, searching.linearSearch(array, 9));
        assertEquals(3, searching.linearSearch(array, 10));
        assertEquals(4, searching.linearSearch(array, -43));
        assertEquals(-1, searching.linearSearch(array, 6));

        assertEquals(-1, searching.linearSearch(new int[]{}, 4));
        assertEquals(0, searching.linearSearch(new int[]{4}, 4));
        assertEquals(0, searching.linearSearch(new int[]{4, 5}, 4));
    }

    @Test
    void test_binarySearch() {
        int[] array = {-43, 2, 5, 9, 10};
        assertEquals(0, searching.binarySearch(array, -43));
        assertEquals(1, searching.binarySearch(array, 2));
        assertEquals(2, searching.binarySearch(array, 5));
        assertEquals(3, searching.binarySearch(array, 9));
        assertEquals(4, searching.binarySearch(array, 10));
        assertEquals(-1, searching.binarySearch(array, 6));

        assertEquals(-1, searching.binarySearch(new int[]{}, 4));
        assertEquals(-1, searching.binarySearch(new int[]{4}, 6));
        assertEquals(0, searching.binarySearch(new int[]{4}, 4));
        assertEquals(0, searching.binarySearch(new int[]{4, 5}, 4));
    }

    @Test
    void test_indexOf() {
        List<String> list = List.of("kaksi", "kolme", "neljä", "yksi");
        assertEquals(Optional.of(0), searching.indexOf(list, "kaksi", naturalOrder()));
        assertEquals(Optional.of(1), searching.indexOf(list, "kolme", naturalOrder()));
        assertEquals(Optional.of(2), searching.indexOf(list, "neljä", naturalOrder()));
        assertEquals(Optional.of(3), searching.indexOf(list, "yksi", naturalOrder()));
        assertEquals(Optional.empty(), searching.indexOf(list, "olematon", naturalOrder()));

        assertEquals(Optional.empty(), searching.indexOf(emptyList(), "yksi", naturalOrder()));
        assertEquals(Optional.empty(), searching.indexOf(List.of("kaksi"), "yksi", naturalOrder()));
        assertEquals(Optional.of(0), searching.indexOf(List.of("kaksi"), "kaksi", naturalOrder()));
        assertEquals(Optional.of(0), searching.indexOf(List.of("kaksi", "yksi"), "kaksi", naturalOrder()));
    }

    @Test
    void test_binarySearchRange() {
//        int[] array = {3, 3, 3, 5, 7, 7, 7, 10, 10, 21};
//        assertRange(0, 2, searching.binarySearchRange(array, 3));
//        assertRange(3, 3, searching.binarySearchRange(array, 5));
//        assertRange(4, 6, searching.binarySearchRange(array, 7));
//        assertRange(7, 8, searching.binarySearchRange(array, 10));
//        assertRange(9, 9, searching.binarySearchRange(array, 21));
//        assertFalse(searching.binarySearchRange(array, 6).isPresent());
//        assertFalse(searching.binarySearchRange(array, 30).isPresent());
//        assertFalse(searching.binarySearchRange(array, -10).isPresent());
//
//        assertFalse(searching.binarySearchRange(new int[]{}, 4).isPresent());
//        assertFalse(searching.binarySearchRange(new int[]{4}, 6).isPresent());
//        assertRange(0, 0, searching.binarySearchRange(new int[]{4}, 4));
//        assertRange(0, 0, searching.binarySearchRange(new int[]{4, 5}, 4));

        int[] arrayp = {3, 3, 3, 5, 7, 7, 7, 7, 7, 10, 10, 21};
        assertRange(4, 8, searching.binarySearchRange(arrayp, 7));
    }

    private void assertRange(int start, int end, Optional<IntRange> range) {
        assertTrue(range.isPresent());
        assertEquals(start, range.get().getStart());
        assertEquals(end, range.get().getEnd());
    }

    @Test
    void test_interpolationSearch() {
        int[] array = {-43, 2, 5, 9, 10};
        assertEquals(0, searching.interpolationSearch(array, -43));
        assertEquals(1, searching.interpolationSearch(array, 2));
        assertEquals(2, searching.interpolationSearch(array, 5));
        assertEquals(3, searching.interpolationSearch(array, 9));
        assertEquals(4, searching.interpolationSearch(array, 10));
        assertEquals(-1, searching.interpolationSearch(array, 6));

        assertEquals(-1, searching.interpolationSearch(new int[]{}, 4));
        assertEquals(-1, searching.interpolationSearch(new int[]{4}, 6));
        assertEquals(0, searching.interpolationSearch(new int[]{4}, 4));
        assertEquals(0, searching.interpolationSearch(new int[]{4, 5}, 4));
    }

}
