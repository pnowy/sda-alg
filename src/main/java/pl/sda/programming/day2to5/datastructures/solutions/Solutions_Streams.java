package pl.sda.programming.day2to5.datastructures.solutions;

import pl.sda.programming.day2to5.datastructures.tasks.Tasks_Streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Solutions_Streams implements Tasks_Streams {
    @Override
    public OptionalInt indexOf(String string, char c) {
        int index = string.indexOf(c);
        return index == -1 ? OptionalInt.empty() : OptionalInt.of(index);
    }

    @Override
    public OptionalInt getMax(int[] ints) {
        return Arrays.stream(ints).max();
    }

    @Override
    public OptionalInt getMax(List<Integer> ints) {
        return ints
                .stream()
                .mapToInt(Integer::intValue)
                .max();

//        return ints
//                .stream()
//                .max(Integer::compareTo);

//        return ints
//                .stream()
//                .max((a, b) -> a - b);

//        return ints
//                .stream()
//                .max((a, b) -> a.compareTo(b));
    }

    @Override
    public OptionalDouble getAverage(List<Integer> integers) {
        return integers
                .stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    @Override
    public OptionalDouble getStudentsAverage(Student... students) {
        return Arrays.stream(students)
                .flatMap(s -> s.getGrades().stream())
//                .peek(System.out::println)
                .mapToDouble(Integer::doubleValue)
                .average();
    }

    @Override
    public String concat(List<Integer> integers) {
        return integers
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    @Override
    public String concatConditional(List<Integer> integers) {
        return integers
                .stream()
                .map(x -> x % 2 == 0 ? "e" + x.toString() : "o" + x.toString())
                .collect(Collectors.joining(",", "[", "]"));
    }

    @Override
    public int sumGreaterThan10(List<Integer> integers) {
        return integers
                .stream()
                .filter(x -> x > 10)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public List<String> distinctUpperCase(List<String> names) {
        return names
                .stream()
                .map(String::toUpperCase)
                .distinct()
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<String> findAuthorByTitle(BookRepository repository, String title) {
        return repository.findByTitle(title).map(Book::getAuthor);
    }

    @Override
    public long numPositive(List<Integer> numbers) {
        return numbers.stream().filter(x -> x > 0).count();
    }

    @Override
    public List<String> authorsOf(Book... books) {
        return Arrays.stream(books)
                .map(Book::getAuthor)
                .sorted()
                .distinct()
                .collect(toList());
    }

    @Override
    public Set<String> keywordsIn(Book... books) {
        return Arrays.stream(books)
                .flatMap(book -> Arrays.stream(book.getTitle().split("\\s+")))
                .map(word -> word.replaceAll("\\W", "").toLowerCase())
                .filter(word -> !word.isEmpty())
                .collect(toSet());
    }

    @Override
    public Map<String, Book> byTitle(List<Book> books) {
        return books.stream().collect(toMap(Book::getTitle, book -> book));
    }

    @Override
    public Map<String, Set<Book>> byAuthor(List<Book> books) {
        return books.stream().collect(groupingBy(Book::getAuthor, toSet()));
    }

    @Override
    public Optional<Book> findMostEditions(Book... books) {
        return Arrays.stream(books)
                .reduce((book1, book2) -> book2.getNumEditions() > book1.getNumEditions() ? book2 : book1);
    }
}
