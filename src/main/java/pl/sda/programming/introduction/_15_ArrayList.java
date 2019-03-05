package pl.sda.programming.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

final class _15_ArrayList {
    public static void main(String[] args) {
        // array
        int[] arr = new int[10];

        // array list - with default capacity 10
        List<Integer> integers = new ArrayList<>();

        // array list - we can pass our own capacity
        List<Integer> ints = new ArrayList<>(50);

        // let's add 100 elements
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int element = random.nextInt(100);
            integers.add(element);
            ints.add(element);
        }
        System.out.println("integers: " + integers);
        System.out.println("ints: " + ints);

        // get elements from list
        int first = integers.get(0);
        System.out.println("first element is " + first);

        int last = integers.get(integers.size() - 1);
        System.out.println("last element is " + last);

        // methods

        // contains element
        boolean containsElement = integers.contains(23);
        System.out.println("array list contains: " + containsElement);

        // is empty
        System.out.println("is list empty? " + integers.isEmpty());

        // how to remove element?
        // remove object
        boolean removedEl1 = integers.remove(new Integer(69));
        System.out.println("removed el by object: " + removedEl1);
        // remove by index
        Integer removedObject = integers.remove(0);
        System.out.println("removed object: " + removedObject);

        System.out.println("integers: " + integers);
        // how to check size
        System.out.println("size is " + integers.size());

        // how to add element in some index
        integers.add(50, 101);
        System.out.println("integers is: " + integers);

        // how to replace element in given index
        integers.set(10, 99999);
        System.out.println("integers is: " + integers);

        // retain only 10 and 20, remove others
        boolean result = integers.retainAll(Arrays.asList(10, 20));
        System.out.println("result is: " + result + ", integers is: " + integers);

        // clear
        integers.clear();
        System.out.println("list is: " + integers);
    }
}
