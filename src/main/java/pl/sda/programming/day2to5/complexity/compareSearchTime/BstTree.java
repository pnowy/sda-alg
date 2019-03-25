package pl.sda.programming.day2to5.complexity.compareSearchTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BstTree {

    private Node root;

    public void insert(Integer element) {
        Node newNode = new Node(element);
        if(root == null) {
            root = newNode;
        } else {
            Node traveler = root;
            while (true) {
                if (element <= traveler.value && traveler.left == null) {
                    traveler.left = newNode;
                    break;
                } else if (element <= traveler.value && traveler.left != null) {
                    traveler = traveler.left;
                } else if (element > traveler.value && traveler.right == null) {
                    traveler.right = newNode;
                    break;
                } else if (element > traveler.value && traveler.right != null) {
                    traveler = traveler.right;
                }
            }
        }
    }

    public boolean contains(Integer element) {
        Node nodeWithValue = getNodeWithValueAndParent(element)[0];
        return nodeWithValue != null;
    }

    public void delete(Integer element) {

        Node[] result = getNodeWithValueAndParent(element);
        Node nodeToBeRemoved = result[0];
        Node parent = result[1];

        if (nodeToBeRemoved == null) {
            return;
        } else if (nodeToBeRemoved == root) {
            if (isLeaf(root)) {
                root = null;
                return;
            } else if (hasOnlyLeftChild(root)) {
                root = root.left;
            } else if (hasOnlyRightChild(root)) {
                root = root.right;
            } else {
                removeNodeHaving2Children(root);
            }
        } else {
            if (isLeaf(nodeToBeRemoved)) {
                if(isLeftChild(nodeToBeRemoved, parent)) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (hasOnlyLeftChild(nodeToBeRemoved)) {
                if(isLeftChild(nodeToBeRemoved, parent)) {
                    parent.left = nodeToBeRemoved.left;
                } else {
                    parent.right = nodeToBeRemoved.left;
                }
            } else if (hasOnlyRightChild(nodeToBeRemoved)) {
                if(isLeftChild(nodeToBeRemoved, parent)) {
                    parent.left = nodeToBeRemoved.right;
                } else {
                    parent.right = nodeToBeRemoved.right;
                }
            } else {
                removeNodeHaving2Children(nodeToBeRemoved);
            }
        }
    }

    private void removeNodeHaving2Children(Node toBeRemoved) {
        Node parentOfLeftMost = toBeRemoved;
        Node leftMost = toBeRemoved.right;
        while (leftMost.left != null ) {
            parentOfLeftMost = leftMost;
            leftMost = leftMost.left;
        }
        Node replacement = leftMost;
        toBeRemoved.value = replacement.value;
        if(isLeftChild(replacement, parentOfLeftMost)) {
            parentOfLeftMost.left = replacement.right;
        } else {
            parentOfLeftMost.right = replacement.right;
        }
    }

    private boolean hasOnlyRightChild(Node node) {
        return node.left == null && node.right != null;
    }

    private boolean hasOnlyLeftChild(Node node) {
        return node.left != null && node.right == null;
    }

    private Node[] getNodeWithValueAndParent(Integer element) {
        Node parent = null;
        Node traveler = root;
        while (traveler != null && !traveler.value.equals(element)) {
            parent = traveler;
            traveler = element <= traveler.value ? traveler.left : traveler.right;
        }
        return new Node[]{traveler, parent};
    }

    private boolean isLeftChild(Node child, Node parent) {
        return child != root && parent.left == child;
    }

    private boolean isLeaf(Node traveler) {
        return traveler.left == null && traveler.right == null;
    }

    public List<Integer> toList() {
        List<Integer> sorted = new ArrayList<>();
        traverseInOrder(root, sorted);
        return sorted;
    }

    private void traverseInOrder(Node node, List<Integer> sorted) {
        if(node == null) {
            return;
        }
        traverseInOrder(node.left, sorted);
        sorted.add(node.value);
        traverseInOrder(node.right, sorted);
    }

    class Node {
        Node left;
        Node right;
        Integer value;

        Node(Integer value) {
            this.value = value;
        }
    }

    public Integer[] toArray() {
        Integer[] array = new Integer[100];
        if(root != null) {
            add(array, root, 0);
        }

        int lastNonEmptyIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                lastNonEmptyIndex = i;
            }
        }

        Integer[] truncatedArray = Arrays.copyOf(array, lastNonEmptyIndex + 1);

        return truncatedArray;
    }

    private void add(Integer[] array, Node node, int index) {
        if (node != null) {
            array[index] = node.value;
            add(array, node.left, index * 2 + 1);
            add(array, node.right, index * 2 + 2);
        }
    }
}
