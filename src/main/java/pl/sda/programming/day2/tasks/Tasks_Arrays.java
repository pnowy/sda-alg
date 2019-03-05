package pl.sda.programming.day2.tasks;

public interface Tasks_Arrays {

    /**
     * Wyszukuje element o wartości value w podanej tablicy i zwraca jego indeks.
     * Zwraca -1 jeśli element nie znajduje się w tablicy.
     */
    int linearSearch(int[] array, int value);

    /**
     * Wylicza średnią liczb w podanej tablicy
     */
    double avg(int[] array);

    /**
     * Wygeneruj tablicę typu int o rozmiarze 'size' z losowymi liczbami.
     */
    double random(int size);

}
