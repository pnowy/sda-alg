package pl.sda.programming.introduction;

import java.util.*;

final class _36_Collection {
    public static void main(String[] args) {
        // Collection
        Collection<String> coll = null;

        /*
            Lists are:
            - ordered
            - not-distinct
            - not-sorted
            - add/remove/update/get it works in the beginning, in the middle, in the end.

            Implementations:
            - ArrayList
                * fast random access
                * very good when we know what is the size of list
                * very good when update element at random index
                * not so good when adding element in the beginning or in the middle
            - LinkedList
                * sequential access (slow if you want random access)
                * very good when adding element in the beginning or end
                * very good when adding/removing elements via iterator
                * not so good when updating element at random index

            If you don't know what to use, just start with ArrayList.
         */

        List<String> arrayList  = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        // convert array into linked list:
        List<String> converted  = new LinkedList<>(arrayList);

        /*
            Sets are:
            - order it's not guaranteed
            - distinct (no duplicates)
            - can be sorted
            - no random access
            - can have null (only one) but be careful!!

            Implementations:
            - HashSet (not-ordered)
            - LinkedHashSet (ordered)
            - TreeSet (sorted)
         */
        List<String> letters = Arrays
                .asList("a", "A", "b", "c", "d", "d", "e", "f", "i", "j");

        Set<String> hashSet = new HashSet<>(letters);
        hashSet.add("g102");
        System.out.println(hashSet);

        Set<String> linkedSet = new LinkedHashSet<>(letters);
        linkedSet.add("g102");
        linkedSet.add("fff");
        System.out.println(linkedSet);

        Set<String> treeSet = new TreeSet<>(letters);
        treeSet.add("g");
        System.out.println(treeSet);
        treeSet.add("z");
        treeSet.add("p");
        treeSet.add("m");
        System.out.println(treeSet);

        Set<String> reversedTree = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1.compareTo(o2));
            }
        });
        reversedTree.addAll(letters);
        System.out.println(reversedTree);


        /*
            Queues:
            - can be FIFO, LIFO
            - order is not guaranteed
            - sort ----- " -------
            - not-distinct
            - you can push, pop, shift, un-shift

            Implementations:
            - LinkedList (Deque)
            - PriorityQueue (using Comparator)
            - ArrayDeque - prefer over LinkedList when it's used as queue
         */
        System.out.println("------- QUEUE --------");
        Queue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1.compareTo(o2));
            }
        });
        priorityQueue.offer("a");
        priorityQueue.offer("b");
        priorityQueue.offer("c");
        priorityQueue.offer("d");
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

        System.out.println("----- DEQUE ------");
        Deque<String> deque = new ArrayDeque<>(letters);
        System.out.println(deque);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
    }
}
