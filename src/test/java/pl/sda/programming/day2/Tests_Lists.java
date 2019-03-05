package pl.sda.programming.day2;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

class Tests_Lists {
    private static final Logger log = LoggerFactory.getLogger(Tests_Lists.class);

    /**
     * Operacje na array list:
     *  - utworzenie pustej listy
     *  - sprawdzenie czy lista jest pusta
     *  - sprawdzenie rozmiaru listy
     *  - dodanie elementu listy (na początku, na końcu, na środku)
     *  - pobranie elementu z listy
     *  - usunięcie elementu z listy
     *
     *  ArrayList vs LinkedList
     *
     *  LinkedList:
     *   - stały czas jeżeli chodzi o operację wstawiania (brak konieczności rozszerzania tablicy)
     *   - dłuższy czas dostępu do konkretnego elementu (brak swobodnego dostępu)
     *
     *  ArrayList:
     *   - bardzo szybki dostęp swodobdny (do dowolnego elementy wg indeksu)
     *   - dodawanie lub usuwanie elementu powoduje konieczność przesuwania elementów w tablicy
     *   - istnieje konieczność od czasu do czasu zmiany rozmiaru tablicy
     *
     *   see more at https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java
     */
    @Test
    void listOperations() {
        List<String> myList = new ArrayList<>();

        myList.add("a");
        myList.add("c");

        log.info("{}", myList);

        myList.add(1, "b");

        log.info("{}", myList);

        myList.remove("b");

        log.info("{}", myList);

    }

}
