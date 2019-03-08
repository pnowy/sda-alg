package pl.sda.programming.day2to5.datastructures;

import org.junit.jupiter.api.Test;
import pl.sda.programming.day2to5.datastructures.solutions.Solutions_Queue;
import pl.sda.programming.day2to5.datastructures.solutions.Solutions_Stack;

import java.util.*;

class Tests_StackAndQueue {

    @Test
    void stackOperations() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");

        System.out.println(stack.peek());

        Solutions_Stack<String> ownStack = new Solutions_Stack<>();
        ownStack.push("pn");
        ownStack.push("sda");
        System.out.println(ownStack.toCoolString());
    }

    @Test
    void queueOperations() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("pn");
        queue.offer("sda");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    @Test
    void dequeOperations() {
        Deque<String> queue = new LinkedList<>();
        queue.offerFirst("pn");
        queue.offerLast("sda");
        queue.offerFirst("aaa");

        System.out.println(queue.getFirst());
    }

    @Test
    void priorityQueue() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(99);
        priorityQueue.offer(12);
        priorityQueue.offer(20);

        System.out.println(priorityQueue.peek());

    }

    @Test
    void testOwnQueue() {
        Solutions_Queue<String> ownQueue = new Solutions_Queue<>();

        ownQueue.enqueue("pn");
        ownQueue.enqueue("sda");

        System.out.println(ownQueue.isEmpty());
        System.out.println(ownQueue.peek());
    }
}
