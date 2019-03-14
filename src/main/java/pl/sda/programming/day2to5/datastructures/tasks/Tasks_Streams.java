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
     * Zwróć maximum z tablicy int-ów.
     */
    OptionalInt getMax(int[] ints);

    /**
     * Zwróć max z listy integerów.
     */
    OptionalInt getMax(List<Integer> ints);

    /**
     * Wylicz średnią z listy int-ów.
     */
    OptionalDouble getAverage(List<Integer> integers);

    /**
     * Wylicz średnią wszystkich studentów
     */
    OptionalDouble getStudentsAverage(Student... students);

    /**
     * Napisz funkcję, która przyjmie liste Integerów i zwróci jeden string który składa się z wszystkich liczb połączonych przecinkami.
     *
     * przykład: [1,2,10] -> "[1,2,10]"
     */
    String concat(List<Integer> integers);


    /**
     * Do funkcji concat dodaj rozpoznawanie czy liczba jest parzysta czy nieparzysta.
     * Jeżeli liczba jest parzysta poprzedz ja "e", jeżeli jest nieparzysta poprzedź ja "o".
     *
     *  przykład: [1,2,10] -> "[o1,e2,e10]"
     */
    String concatConditional(List<Integer> integers);

    /**
     * Napisz metodę która zsumuje liczby wieksze niż 10
     */
    int sumGreaterThan10(List<Integer> integers);

    /**
     * Napisz funkcję która dostanie listę imion, każde imie zapisze wielkimi literami i zwróci tylko unikalne imiona.
     * Dodatkowo funkcja ma zwracać maksymalnie 10 imion
     */
    List<String> distinctUpperCase(List<String> names);

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

    class Student {
        private String name;
        private List<Integer> grades;

        public Student(String name, Integer ... grades) {
            this.name = name;
            this.grades = Arrays.asList(grades);
        }

        public String getName() {
            return name;
        }

        public List<Integer> getGrades() {
            return grades;
        }
    }

}
