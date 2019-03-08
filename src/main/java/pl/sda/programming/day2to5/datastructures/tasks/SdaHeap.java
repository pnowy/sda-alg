package pl.sda.programming.day2to5.datastructures.tasks;

import java.util.NoSuchElementException;

public interface SdaHeap<T extends Comparable<T>> {

    /**
     * Dodaje nowy element do kopca. Po dodaniu elementu do tablicy, własność kopca musi zostać zachowana.
     *
     * @throws IllegalStateException jeśli kopiec jest pełny
     */
    void push(T element);

    /**
     * Usuwa z kopca i zwraca element o najwyższej wartości.
     *
     * @throws NoSuchElementException jeśli kopiec jest pusty
     */
    T pop();

    /**
     * Zwraca ilość elementów na kopcu.
     */
    int size();

    /**
     * Zwraca tablicę zawierającą elementy kopca.
     */
    T[] toArray();

}
