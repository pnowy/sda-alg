package pl.sda.programming.day2to5.datastructures.solutions;

import pl.sda.programming.day2to5.datastructures.tasks.SdaBst;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SdaBstImpl<T extends Comparable<T>> implements SdaBst<T> {

    private Node root;

    public SdaBstImpl(T[] elements) {
        for (T element : elements) {
            insert(element);
        }
    }

    @Override
    public void insert(T element) {
        if (root == null) {
            root = new Node(element, null, null);
        } else {
            insert(root, element);
        }
    }

    private void insert(Node node, T element) {
        if (node.value.compareTo(element) < 0) { // sprawdzamy tutaj wynik funkcji compare, tzn. czy element dodawany ma mniejszą wartość niż obecna wartość dla węzła
            if (node.right == null) {
                node.right = new Node(element, null, null);
            } else {
                insert(node.right, element);
            }
        } else if (node.value.compareTo(element) > 0) {
            if (node.left == null) {
                node.left = new Node(element, null, null);
            } else {
                insert(node.left, element);
            }
        } else {
            node.value = element;
        }
    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(Node node, T element) {
        if (node == null) {
            return false;
        } else {
            return node.value == element || contains(node.left, element) || contains(node.right, element);
        }
    }

    @Override
    public void delete(T element) {
        root = delete(root, element);
    }

    private Node delete(Node node, T element) {
        if (node == null) {                             // ¯\_(ツ)_/¯
            return null;
        } else if (node.value.compareTo(element) < 0) { // węzeł do usunięcia znajduje się w prawym poddrzewie
            node.right = delete(node.right, element);
            return node;
        } else if (node.value.compareTo(element) > 0) { // węzeł do usunięcia znajduje się w lewym poddrzewie
            node.left = delete(node.left, element);
            return node;
        } else if (node.left == null) {                 // węzeł do usunięcia ma co najwyżej prawe dziecko
            return node.right;
        } else if (node.right == null) {                // węzeł do usunięcia ma co najwyżej lewe dziecko
            return node.left;
        } else {                                        // węzeł do usunięcia ma dwoje dzieci
            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            delete(node, successor.value);
            node.value = successor.value;
            return node;
        }
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        inOrder(root, list::add);
        return list;
    }

    private void inOrder(Node node, Consumer<T> visitor) {
        if (node == null) {
            return;
        }
        inOrder(node.left, visitor);
        visitor.accept(node.value);
        inOrder(node.right, visitor);
    }

    private class Node {

        private T value;
        private Node left;
        private Node right;

        public Node(T value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
