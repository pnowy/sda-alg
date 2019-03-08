package pl.sda.programming.day2to5.datastructures.tasks;

import pl.sda.programming.day2to5.datastructures.solutions.SdaBstImpl;

public class Tasks_Bst {

    public <T extends Comparable<T>> SdaBst<T> createBst(T[] elements) {
        return new SdaBstImpl<>(elements);
    }

}
