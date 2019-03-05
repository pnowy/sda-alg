package pl.sda.programming.introduction;

import java.util.*;

final class _39_Lambda {

    public static void main(String[] args) {
        /*
            What is lambda?
            - it's an anonymous function:
              * parameter list
              * body
            - it's interface implementation (like anonymous inner class)
              BUT it's only valid when there is one single abstract method
            - cannot have state
            - PREFER LAMBDA OVER ANONYMOUS CLASSES!!!!
         */

        List<String> words = new ArrayList<>(Arrays.asList("w1", "w2", "w3"));
        // external iterator
        for (String s : words) {
            System.out.println(s);
        }

        // internal iterator
        words.forEach(element -> System.out.println(element + " test"));

        words.removeIf(word -> word.endsWith("2"));
        System.out.println(words);

        // Method reference
        words.forEach(System.out::println);

        // lazy evaluation
        System.out.println("------ LAZY EVALUATION ------");
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "test");
        // -----------------------------------------

        // -----------------------------------------
        // map.putIfAbsent(10, HardComputing.compute(10));

        // ----------- DO IT IF NECESSARY -----------
        map.computeIfAbsent(10, HardComputing::compute);
        System.out.println(map);

        // BiFunction
        map.computeIfPresent(10, (key, value) -> HardComputing.compute(key, value));
        map.computeIfPresent(10, HardComputing::compute); // method reference for more then 1 argument
        System.out.println(map);
    }
}

class HardComputing {
    static String compute(Integer key) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "test 2";
    }

    static String compute(Integer key, String value) {
        return (key * 2) + "_" + value;
    }
}

/*
    Functional Interfaces examples:
    - Function<T,R> - R apply(T t);
    - Predicate<T>  - boolean test(T t);
    - Consumer<T>   - void accept(T t);
    - Supplier<T>   - T get();
    - BiFunction<T, V, R> - R accept(T t, V v);

    Higher order functions:
    - you can pass function into function as an argument
    - you can return function from function
 */
@FunctionalInterface
interface MyAwesomeFunctionalInterface<T,R> {
    R apply(T t);

    // functional interface is only when there is one single abstract method
    // void test();
}