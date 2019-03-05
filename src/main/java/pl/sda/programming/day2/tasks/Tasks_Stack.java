package pl.sda.programming.day2.tasks;

import java.util.Optional;

public interface Tasks_Stack<T> {

    void push(T element);

    Optional<T> pop();

    Optional<T> peek();

    boolean isEmpty();

    String toCoolString();

}
