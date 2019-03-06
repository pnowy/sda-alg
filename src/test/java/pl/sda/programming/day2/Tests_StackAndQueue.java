package pl.sda.programming.day2;

import org.junit.jupiter.api.Test;
import pl.sda.programming.day2.solutions.Solutions_Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

}
