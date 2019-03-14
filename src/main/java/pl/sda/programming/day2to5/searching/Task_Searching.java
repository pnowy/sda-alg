package pl.sda.programming.day2to5.searching;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface Task_Searching {

    /**
     * Wyszukuje element o wartości value w podanej tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     */
    int linearSearch(int[] array, int value);

    /**
     * Wyszukuje element o wartości value w podanej POSORTOWANEJ tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     */
    int binarySearch(int[] array, int value);

    /**
     * Wyszukuje element o wartości value w podanej POSORTOWANEJ liście i zwraca jego indeks.
     */
    <T> Optional<Integer> indexOf(List<T> list, T value, Comparator<T> comparator);

    /**
     * Wyszukuje wszystkie elementy o wartości value w podanej POSORTOWANEJ tablicy i zwraca zakres ich indeksów.
     */
    Optional<IntRange> binarySearchRange(int[] array, int value);

    /**
     * Wyszukuje element o wartości value w podanej POSORTOWANEJ tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     *
     * Uwaga: należy zastosować wyszukiwanie interpolacyjne (interpolation search).
     */
    int interpolationSearch(int[] array, int value);

    class IntRange {
        private final int start;
        private final int end;

        public IntRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

}
