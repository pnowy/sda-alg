package pl.sda.programming.day2.tasks;

public class Tasks_Bst {

    public <T extends Comparable<T>> SdaBst<T> createBst(T[] elements) {
        return new SdaBstImpl<>(elements);
    }

}
