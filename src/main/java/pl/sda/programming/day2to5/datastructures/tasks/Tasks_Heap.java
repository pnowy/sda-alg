package pl.sda.programming.day2to5.datastructures.tasks;

public interface Tasks_Heap {

    /**
     * Zwraca true jeśli elementy w podanej tablicy tworzą kopiec,
     * tzn. tworzą kompletne drzewo binarne, w którym każdy węzeł
     * ma wartość większą lub równą wartości swoich dzieci.
     */
    boolean isHeap(int[] array);

    <T extends Comparable<T>> SdaHeap<T> createHeap(T[] heap, int capacity);

}
