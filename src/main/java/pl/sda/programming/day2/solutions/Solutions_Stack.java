package pl.sda.programming.day2.solutions;

import pl.sda.programming.day2.tasks.Tasks_Stack;

import java.util.Optional;

public class Solutions_Stack<T> implements Tasks_Stack<T> {

    private Node<T> top;

    @Override
    public void push(T element) {
        if (top == null) {
            top = new Node<>(element);
        } else {
            Node node = new Node<>(element);
            node.bottomNext = top;
            top = node;
        }
    }

    @Override
    public Optional<T> pop() {
        if (top == null) {
            return Optional.empty();
        } else {
            Optional<T> num = Optional.of(top.value);
            top = top.bottomNext;
            return num;
        }
    }

    @Override
    public Optional<T> peek() {
        if (top == null) {
            return Optional.empty();
        } else {
            return Optional.of(top.value);
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toCoolString() {
        String coolString = "";
        Node walker = top;
        while (walker != null) {
            coolString += "+-----+\n" +
                    "| " + walker.value + " |\n" +
                    "+-----+\n" +
                    "   |   \n";

            walker = walker.bottomNext;
        }
        return coolString;
    }

    private static class Node<T> {
        T value;
        Node bottomNext;

        Node(T value) {
            this.value = value;
        }
    }
}
