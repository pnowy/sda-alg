package pl.sda.programming.day2.tasks;

import java.util.Optional;

public interface Tasks_Queue<T> {
    void enqueue(T i);

    Optional<T> dequeue();

    boolean isEmpty();

    Optional<T> peek();
}
