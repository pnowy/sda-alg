package pl.sda.programming.day2to5.streams;

import org.junit.jupiter.api.Test;
import pl.sda.programming.day2to5.datastructures.solutions.Solutions_Streams;
import pl.sda.programming.day2to5.datastructures.tasks.Tasks_Streams;
import pl.sda.programming.day2to5.datastructures.tasks.Tasks_Streams.Book;
import pl.sda.programming.day2to5.datastructures.tasks.Tasks_Streams.BookRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Test_Streams {

    Tasks_Streams streams = new Solutions_Streams();

    private Book effectiveJava   = new Book("Effective Java", "Joshua Bloch", 3);
    private Book finnishGrammar  = new Book("Finnish: An Essential Grammar", "Fred Karlsson", 3);
    private Book cleanCode       = new Book("Clean Code", "Robert C. Martin", 1);
    private Book cleanCoder      = new Book("The Clean Coder", "Robert C. Martin", 1);
    private Book javaConcurrency = new Book("Java Concurrency in Practice", "Brian Goetz", 1);

    @Test
    void test_indexOf() {
        assertEquals(6, streams.indexOf("To jest test", 't').getAsInt());
        assertFalse(streams.indexOf("To jest test", 'Z').isPresent());
        assertFalse(streams.indexOf("", 'X').isPresent());
    }

    @Test
    void test_findAuthorByTitle() {
        Map<String, Book> books = Map.of(
                effectiveJava.getTitle(), effectiveJava,
                cleanCode.getTitle(), cleanCode,
                cleanCoder.getTitle(), cleanCoder,
                javaConcurrency.getTitle(), javaConcurrency);

        BookRepository repository = title -> Optional.ofNullable(books.get(title));

        assertEquals("Robert C. Martin", streams.findAuthorByTitle(repository, "Clean Code").get());
        assertFalse(streams.findAuthorByTitle(repository, "Programming in Scala").isPresent());
    }

    @Test
    void test_numPositive() {
        assertEquals(5, streams.numPositive(List.of(-9, 40, 2, 0, 4, -5, 98, 40, -5)));
        assertEquals(0, streams.numPositive(emptyList()));
        assertEquals(0, streams.numPositive(List.of(-20)));
    }

    @Test
    void test_titlesOf() {
        assertEquals(
                List.of("Brian Goetz", "Joshua Bloch", "Robert C. Martin"),
                streams.authorsOf(effectiveJava, cleanCode, cleanCoder, javaConcurrency));

        assertEquals(emptyList(), streams.authorsOf());
    }

    @Test
    void test_keywordsIn() {
        assertEquals(
                Set.of("effective", "java", "clean", "code", "coder", "the", "finnish", "an", "essential", "grammar"),
                streams.keywordsIn(effectiveJava, cleanCode, cleanCoder, finnishGrammar));

        assertEquals(Set.of("fake", "title"), streams.keywordsIn(new Book("Fake - \t Title ", "Me", 0)));
    }

    @Test
    void test_byTitle() {
        assertEquals(
                Map.of(
                        effectiveJava.getTitle(), effectiveJava,
                        cleanCode.getTitle(), cleanCode,
                        cleanCoder.getTitle(), cleanCoder,
                        javaConcurrency.getTitle(), javaConcurrency),
                streams.byTitle(List.of(effectiveJava, cleanCode, cleanCoder, javaConcurrency)));
    }

    @Test
    void test_byAuthor() {
        assertEquals(
                Map.of(
                        "Joshua Bloch", Set.of(effectiveJava),
                        "Robert C. Martin", Set.of(cleanCode, cleanCoder),
                        "Brian Goetz", Set.of(javaConcurrency)),
                streams.byAuthor(List.of(effectiveJava, cleanCode, cleanCoder, javaConcurrency)));
    }

    @Test
    void test_findMostEditions() {
        assertEquals(effectiveJava, streams.findMostEditions(cleanCode, effectiveJava, finnishGrammar, cleanCoder).get());
        assertEquals(finnishGrammar, streams.findMostEditions(cleanCode, finnishGrammar, effectiveJava, cleanCoder).get());
        assertEquals(javaConcurrency, streams.findMostEditions(javaConcurrency).get());
        assertFalse(streams.findMostEditions().isPresent());
    }

}
