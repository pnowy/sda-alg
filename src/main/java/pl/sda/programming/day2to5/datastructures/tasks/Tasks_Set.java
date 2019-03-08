package pl.sda.programming.day2to5.datastructures.tasks;

import java.util.List;
import java.util.Set;

public interface Tasks_Set {

    /**
     * Funkcja zwraca zbiór wartości, które występują więcej niż raz w liście "values".
     *
     */
    <T> Set<T> findDuplicates(List<T> values);

    /**
     * Funkcja zwraca zbiór wszystkich wartości występujących w obu podanych listach.
     */
    <T> Set<T> findCommonValues(List<T> list1, List<T> list2);

}
