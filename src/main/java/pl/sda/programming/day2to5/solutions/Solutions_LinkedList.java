package pl.sda.programming.day2to5.solutions;

import pl.sda.programming.day2to5.tasks.Tasks_LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Solutions_LinkedList<T> implements Tasks_LinkedList<T> {

    private Node<T> head;

    public Solutions_LinkedList(T[] elements) {
        for (int i = elements.length - 1; i >= 0; i--) {
            addFirst(elements[i]);
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        Node<T> node = head;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.element;
    }

    @Override
    public T getLast() {
        return nodeLast().element;
    }

    @Override
    public T get(int index) {
        return nodeAt(index).element;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public void addFirst(T element) {
        head = new Node<>(element, head);
    }

    @Override
    public void addLast(T element) {
        if (isEmpty()) {
            addFirst(element);
        } else {
            nodeLast().next = new Node<>(element, null);
        }
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        head = head.next;
    }

    @Override
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (head.next == null) { // lista ma tylko jeden element
            head = null;
            return;
        }

        Node<T> prev = head;
        Node<T> last = head.next;
        while (last.next != null) {
            prev = last;
            last = last.next;
        }
        prev.next = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (node == null) {
                    throw new NoSuchElementException();
                }
                T element = node.element;
                node = node.next;
                return element;
            }
        };
    }

    @Override
    public void setAt(int index, T element) {
        nodeAt(index).element = element;
    }

    @Override
    public void addAt(int index, T element) {
        if (index == 0) {
            addFirst(element);
        } else {
            Node<T> prev = nodeAt(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
    }

    @Override
    public void removeAt(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds, actual size 0");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<T> prev = nodeAt(index - 1);
            if (prev.next == null) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds, actual size " + index);
            }
            prev.next = prev.next.next;
        }
    }

    private Node<T> nodeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    private Node<T> nodeAt(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is negative");
        }
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds, actual size 0");
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++) { // wykonaj 'index' kroków z węzła na węzeł
            node = node.next;
            if (node == null) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds, actual size " + (i + 1));
            }
        }
        return node;
    }

    private static class Node<T> {

        private T element;
        private Node<T> next;

        private Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

}
