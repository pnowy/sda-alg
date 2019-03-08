package pl.sda.programming.day2to5.datastructures.tasks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Tasks_LinkedList<T> extends Iterable<T> {

    /**
     * Zwraca true jeśli lista jest pusta.
     */
    boolean isEmpty();

    /**
     * Zwraca rozmiar listy (ilość elementów).
     */
    int size();

    /**
     * Zwraca pierwszy element listy.
     *
     * @throws NoSuchElementException jeśli lista jest pusta
     */
    T getFirst();

    /**
     * Zwraca ostatni element listy.
     *
     * @throws NoSuchElementException jeśli lista jest pusta
     */
    T getLast();

    /**
     * Pobiera element listy pod podanym indeksem.
     *
     * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
     */
    T get(int index);

    /**
     * Usuwa wszystkie elementy z listy.
     */
    void clear();

    /**
     * Dodaje nowy element na początku listy.
     */
    void addFirst(T element);

    /**
     * Dodaje nowy element na końcu listy.
     */
    void addLast(T element);

    /**
     * Usuwa pierwszy element listy.
     *
     * @throws NoSuchElementException jeśli lista jest pusta
     */
    void removeFirst();

    /**
     * Usuwa ostatni element listy.
     *
     * @throws NoSuchElementException jeśli lista jest pusta
     */
    void removeLast();

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Zwraca iterator po elementach listy.
     *
     * @see java.lang.Iterable
     */
    @Override
    Iterator<T> iterator();

    /**
     * Zamienia element pod podanym indeksem.
     */
    void setAt(int index, T element);

    /**
     * Dodaje nowy element pod wskazanym indeksem.
     *
     * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
     */
    void addAt(int index, T element);

    /**
     * Usuwa element pod wskazanym indeksem.
     *
     * @throws IndexOutOfBoundsException jeśli indeks leży poza zakresem listy
     */
    void removeAt(int index);

}
