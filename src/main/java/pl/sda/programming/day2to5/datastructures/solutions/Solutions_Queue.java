package pl.sda.programming.day2to5.datastructures.solutions;

import pl.sda.programming.day2to5.datastructures.tasks.Tasks_Queue;

import java.util.Optional;

public class Solutions_Queue<T> implements Tasks_Queue<T> {

    Node<T> first;
    Node<T> last;

    public void enqueue(T i) {
        if(last == null) {
            Node<T> node = new Node<>(i);
            last = node;
            first = node;
        } else {
            Node<T> node = new Node<>(i);
            last.next = node;
            last = node;
        }
    }

    public Optional<T> dequeue() {
        if(first == null) {
            return Optional.empty();
        } else {
            Node<T> x = first;
            first = first.next;
            if(first == null) {
                last = null;
            }
            return Optional.of(x.value);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Optional<T> peek() {
        if(first == null) {
            return Optional.empty();
        } else {
            return Optional.of(first.value);
        }
    }
    //enqueue/dequeue/peek/isEmpty

    class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

}
