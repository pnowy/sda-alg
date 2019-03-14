package pl.sda.programming.day2to5.datastructures.tasks;

import java.util.*;

/**
 * Zaimplementuj poniższe metody z użyciem wyrażeń lambda i/lub klas Stream oraz Optional.
 */
public interface Tasks_Streams {

    /**
     * Funkcja zwraca pierwszy indeks pod którym
     * określony znak znajduje się w podanym Stringu.
     */
    OptionalInt indexOf(String string, char c);

    /**
     * Znajduje autora książki o podanym tytule.
     */
    Optional<String> findAuthorByTitle(BookRepository repository, String title);

    /**
     * Funkcja zwraca ilość liczb dodatnich w podanej liście.
     */
    long numPositive(List<Integer> numbers);

    /**
     * Funkcja zwraca listę autorów książek znajdujących się na podanej liście.
     * Wynikowa lista jest posortowana alfabetycznie oraz nie zawiera duplikatów.
     */
    List<String> authorsOf(Book... books);

    /**
     * Funkcja zwraca wszystkie słowa występujące w tytułach podanych książek.
     * Znaki inne niż litery i cyfry (non-word characters) są usunięte z wyrazów.
     * Zwrócone wyrazy zapisane są małymi literami.
     */
    Set<String> keywordsIn(Book... books);

    /**
     * Zwraca mapę pozwalającą znaleźć książki po tytule.
     */
    Map<String, Book> byTitle(List<Book> books);

    /**
     * Zwraca mapę pozwalającą znaleźć książki po autorze.
     */
    Map<String, Set<Book>> byAuthor(List<Book> books);

    /**
     * Funkcja zwraca z podanej list książkę, która ma najwięcej edycji.
     * Jeśli więcej niż jedna książka ma tyle samo edycji, zwrócona jest książka pierwsza w kolejności.
     *
     * Podpowiedź: przyda się funkcja Stream.reduce.
     */
    Optional<Book> findMostEditions(Book... books);

    interface BookRepository {
        Optional<Book> findByTitle(String title);
    }

    class Book {
        private final String title;
        private final String author;
        private final int numEditions;

        public Book(String title, String author, int numEditions) {
            this.title = title;
            this.author = author;
            this.numEditions = numEditions;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getNumEditions() {
            return numEditions;
        }
    }

}
