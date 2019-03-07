package pl.sda.programming.day2to5.tasks;

import java.util.Comparator;
import java.util.List;

public interface Tasks_Tree {

    /**
     * Przechodzi podane drzewo w kolejności pre-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    <T> List<T> traversePreOrder(SdaTree<T> tree);

    /**
     * Przechodzi podane drzewo w kolejności in-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    <T> List<T> traverseInOrder(SdaTree<T> tree);

    /**
     * Przechodzi podane drzewo w kolejności post-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem rekurencji.
     */
    <T> List<T> traversePostOrder(SdaTree<T> tree);

    /**
     * Funkcja działa tak samo jak traversePreOrder.
     *
     * Uwaga: metodę należy zaimplementować z wykorzystaniem stosu (bez rekurencji).
     */
    <T> List<T> traversePreOrderIterative(SdaTree<T> tree);

    /**
     * Przechodzi podane drzewo w kolejności level-order i zwraca listę
     * elementów w kolejności takiej, w jakiej były napotkane.
     *
     * Podpowiedź: implementacja jest bardzo podobna do traversePreOrderIterative,
     * ale zamiast stosu wykorzystuje inną strukturę danych.
     */
    <T> List<T> traverseLevelOrder(SdaTree<T> tree);

    /**
     * Funkcja zwraca liczbę liści w podanym drzewie.
     */
    int countLeaves(SdaTree<?> tree);

    /**
     * Tworzy drzewo binarne na podstawie podanego tekstu.
     *
     * Drzewo, w którym węzły mogą posiadać co najwyżej dwóch synów, nazywa się drzewem binarnym (ang. binary tree, B-tree).
     * Węzły potomne nazywamy odpowiednio synem lewym (ang. left child node) i synem prawym (ang. right child node)
     *
     * Tekst zawiera tyle linijek, ile poziomów ma drzewo.
     * Każda linijka zawiera wartości węzłów na odpowiednim poziomie rozdzielone spacjami, po kolei,
     * czyli każda linijka zawiera dwa razy więcej wartości niż poprzednia.
     * Wartość "-" oznacza, że węzeł na danej pozycji nie istnieje.
     *
     * Np. drzewo ze slajdów przedstawione byłoby jako "F\nB G\nA D - I\n- - C E - - H -",
     * czyli zapisując w wielu liniach:
     * F
     * B G
     * A D - I
     * - - C E - - H -
     *
     * Uwaga: nie należy modyfikować klas SdaTree i SdaTreeImpl.
     *
     * @throws IllegalArgumentException jeśli któraś z linijek zawiera nieprawidłową ilość wartości
     */
    SdaTree<String> buildTree1(String input);

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    /**
     * Tworzy drzewo binarne na podstawie podanego tekstu.
     *
     * Każda linijka zawiera informację o parze rodzic-dziecko.
     * Format każdej linijki wygląda następująco:
     *
     * left(rodzic)=dziecko
     *
     * lub
     *
     * right(rodzic)=dziecko
     *
     * dla lewego i prawego dziecka odpowiednio.
     *
     * Uwaga: nie należy modyfikować klas SdaTree i SdaTreeImpl.
     *
     * @throws IllegalArgumentException jeśli któraś z linijek jest niezgodna z powyższym formatem
     */
    SdaTree<String> buildTree2(String input);

    /**
     * Funkcja oblicza wysokość drzewa.
     *
     * Przypomnienie: wysokość drzewa składającego się jedynie z korzenia to 0.
     */
    int calcHeight(SdaTree<?> tree);

    /**
     * Funkcja znajduje największy element w drzewie.
     */
    <T> T findMax(SdaTree<T> tree, Comparator<T> comparator);

}
