package pl.sda.programming.introduction;


import pl.sda.programming.introduction.shop.model.Person;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

final class _40_Streams {

    public static void main(String[] args) {
        /*
            What is stream?
            - sequence of elements,
            - it's an abstraction
            - it's a pipeline of declared computations
            - it can be created from array, collections,
              generator function or I/O,
         */

        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 6);

        System.out.println(numbers.stream()
                .filter(i -> i > 3)
                .filter(i -> i % 2 == 0)
                .mapToInt(i -> i * 2)
                //.reduce(0, (result, i) -> result + i)
                //.sum()
                .summaryStatistics()
        );
        /*
        Stream        filter(i > 3)       filter(i%2 == 0)        map(i*2)        reduce(sum) = 0
        ------------------------------------------------------------------          |
        1                 -                                                         |
        ------------------------------------------------------------------
        3                 -                                                         |
        ------------------------------------------------------------------
        4                 4                     4                    8              0+8 = 8
        ------------------------------------------------------------------
        5                 5                     -                                   |
        ------------------------------------------------------------------
        6                 6                     6                    12             8+12 = 20  ----->
        ------------------------------------------------------------------
         */

        OptionalDouble result = numbers.stream()
                .filter(i -> i > 3)
                .filter(i -> i % 2 == 0)
                .mapToInt(i -> i * 2)
                //.reduce(0, (result, i) -> result + i)
                //.sum()
                .average();

        if (result.isPresent()) {
            System.out.println(result.getAsDouble());
        }


        // find first element
        List<String> words = Arrays.asList("w1", "w3", "c1", "a2", "r4");
        Optional<String> resultWord = words.stream()
                .filter(word -> word.endsWith("8"))
                .findFirst();
        System.out.println(resultWord.orElse("🐶"));

        // collect filtered elements to list
        // DON'T DO THIS
        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 6, 7, 8);
        // double even numbers and put into list
        List<Integer> resultInts = new ArrayList<>();
        integers.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .forEach(i -> resultInts.add(i)); // DON'T DO THIS

        // how to do it correctly:
        List<Integer> resultCorrect = integers.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .collect(toList());
        System.out.println(resultCorrect);

        // grouping and mapping
        List<Person> people = Arrays.asList(
                new Person("Jan", "Kowalski"),
                new Person("Jan", "Nowak"),
                new Person("Adam", "Cios"),
                new Person("Kamil", "J"),
                new Person("Adam", "Kotek")
        );

        Map<String, List<String>> grouped = people.stream()
                .collect(groupingBy(Person::getFirstName, mapping(Person::getLastName, toList())));
        System.out.println(grouped);

        // Stream is lazy
        Stream<Integer> stream = Stream.of(12, 9, 1, 2, 3, 4, 4, 6, 6, 7)
                .distinct()  // Lazy
                .sorted();   // Lazy
        System.out.println(stream);
        System.out.println(stream.collect(toList()));  // terminal

        // stream.forEach(i -> System.out.println(i)); Once stream is executed cannot be executed again!!!

        /*
            Stream has a 2 kinds of operations:
            - intermediate (lazy):
                * map
                * filter
                * sorted
                * limit
                * distinct
            - terminal (do it!!)
                * reduce
                * findFirst
                * findAny
                * anyMatch
                * sum
                * average
                * forEach
         */

        // how to create a Stream from generator function
        Stream.iterate(1, e -> e + 1)
            .filter(i -> i % 3 == 0)
            .map(i -> i * 2)
            .skip(5)
            .limit(10)
            .forEach(System.out::println);
    }
}

class Imperative {
    /*
        start with 'k' and find the total of double of 'n' even numbers, where sqrt of each number is > 20.
     */
    static int compute(int k, int n) {
        int result = 0;
        int index  = k;
        int count  = 0;
        while (count < n) {
            if (index % 2 == 0 && Math.sqrt(index) > 20) {
                result += index * 2;
                count++;
            }
            index++;
        }
        return result;
    }
}

class Declarative {

    static int compute(int k, int n) {
        return Stream.iterate(k, e -> e + 1)
                .filter(e -> e % 2 == 0)
                .filter(e -> Math.sqrt(e) > 20)
                .mapToInt(e -> e * 2)
                .limit(n)
                .sum();
    }
}