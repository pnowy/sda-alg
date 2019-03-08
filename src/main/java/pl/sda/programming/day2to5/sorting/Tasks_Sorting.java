package pl.sda.programming.day2to5.sorting;

public interface Tasks_Sorting {

    /**
     * Sortowanie bąbelkowe (bubble sort)
     *
     * Sortowanie bąbelkowe (bubble sort) – prosta metoda sortowania o złożoności czasowej
     * O(n2) i pamięciowej O(1). Polega na porównywaniu dwóch kolejnych elementów i zamianie
     * ich kolejności, jeżeli zaburza ona porządek, w jakim się sortuje tablicę.
     * Sortowanie kończy się, gdy podczas kolejnego przejścia nie dokonano żadnej zmiany.
     */
    void bubbleSort(int[] array);

    /**
     * Sortowanie przez wybieranie (selection sort)
     *
     * Sortowanie przez wybieranie (selection sort) - jedna z prostszych metod sortowania o 
     * złożoności O(n2). Polega na wyszukaniu elementu mającego się znaleźć na żądanej pozycji
     * i zamianie miejscami z tym, który jest tam obecnie. Operacja jest
     * wykonywana dla wszystkich indeksów sortowanej tablicy.
     */
    void selectionSort(int[] array);

    /**
     * Sortowanie przez wstawianie (insertion sort).
     *
     * Sortowanie przez wstawianie (insertion sort) – jeden z najprostszych algorytmów sortowania,
     * którego zasada działania odzwierciedla sposób w jaki ludzie ustawiają karty – kolejne elementy
     * wejściowe są ustawiane na odpowiednie miejsca docelowe. Jest efektywny dla niewielkiej
     * liczby elementów, jego złożoność wynosi O(n2). 
     */
    void insertionSort(int[] array);

    /**
     * Sortowanie szybkie (quicksort, category divide and conquer)
     *
     * Sortowanie szybkie (quicksort) – jeden z popularnych algorytmów sortowania działających na zasadzie "dziel i zwyciężaj".
     */
    void quickSort(int[] array);

    /**
     * Sortowanie przez scalanie (merge sort)
     *
     * Sortowanie przez scalanie (merge sort) – rekurencyjny algorytm sortowania danych, stosujący metodę ”dziel i zwyciężaj”.
     */
    void mergeSort(int[] array);

}
