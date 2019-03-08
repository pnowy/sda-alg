package pl.sda.programming.day2to5.datastructures;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import pl.sda.programming.day2to5.datastructures.solutions.Solutions_Tree;
import pl.sda.programming.day2to5.datastructures.tasks.SdaTree;
import pl.sda.programming.day2to5.datastructures.tasks.Tasks_Tree;

import java.util.Optional;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Tests_Tree {

    private Tasks_Tree exercises = new Solutions_Tree();

    // takie samo drzewo jak na prezentacji
    private SdaTree<String> exampleTree =
            SdaTree.of("F",
                    SdaTree.of("B",
                            SdaTree.leaf("A"),
                            SdaTree.of("D",
                                    SdaTree.leaf("C"),
                                    SdaTree.leaf("E"))),
                    SdaTree.of("G",
                            null,
                            SdaTree.of("I",
                                    SdaTree.leaf("H"),
                                    null)));


    @Test
    void test_traversePreOrder() {
        assertEquals(Lists.newArrayList("F", "B", "A", "D", "C", "E", "G", "I", "H"), exercises.traversePreOrder(exampleTree));
        assertEquals(Lists.newArrayList(20), exercises.traversePreOrder(SdaTree.leaf(20)));
    }

    @Test
    void test_traverseInOrder() {
        assertEquals(Lists.newArrayList("A", "B", "C", "D", "E", "F", "G", "H", "I"), exercises.traverseInOrder(exampleTree));
        assertEquals(Lists.newArrayList(20), exercises.traverseInOrder(SdaTree.leaf(20)));
    }

    @Test
    void test_traversePostOrder() {
        assertEquals(Lists.newArrayList("A", "C", "E", "D", "B", "H", "I", "G", "F"), exercises.traversePostOrder(exampleTree));
        assertEquals(Lists.newArrayList(20), exercises.traversePostOrder(SdaTree.leaf(20)));
    }

    @Test
    void test_traversePreOrderIterative() {
        assertEquals(Lists.newArrayList("F", "B", "A", "D", "C", "E", "G", "I", "H"), exercises.traversePreOrderIterative(exampleTree));
        assertEquals(Lists.newArrayList(20), exercises.traversePreOrderIterative(SdaTree.leaf(20)));
    }

    @Test
    void test_traverseLevelOrder() {
        assertEquals(Lists.newArrayList("F", "B", "G", "A", "D", "I", "C", "E", "H"), exercises.traverseLevelOrder(exampleTree));
        assertEquals(Lists.newArrayList(20), exercises.traverseLevelOrder(SdaTree.leaf(20)));
    }

    @Test
    void test_countLeaves() {
        assertEquals(4, exercises.countLeaves(exampleTree));
        assertEquals(3, exercises.countLeaves(exampleTree.getLeftChild().get()));
        assertEquals(1, exercises.countLeaves(exampleTree.getRightChild().get()));
        assertEquals(1, exercises.countLeaves(SdaTree.leaf(42)));
    }

    @Test
    void test_buildTree1() {
        assertTreeEquals(exampleTree, exercises.buildTree1("F\nB G\nA D - I\n- - C E - - H -"));
        assertTreeEquals(SdaTree.leaf("root"), exercises.buildTree1("root"));
        assertThrows(IllegalArgumentException.class, () -> exercises.buildTree1(""));
        assertThrows(IllegalArgumentException.class, () -> exercises.buildTree1("r1 r2"));
        assertThrows(IllegalArgumentException.class, () -> exercises.buildTree1("F\nB G\nA D - I\n- C E - - H -"));
    }

    ////////////////////////////////////////////
    //                                        //
    // PONIŻEJ ZADANIA DODATKOWE DLA CHĘTNYCH //
    //                                        //
    ////////////////////////////////////////////

    @Test
    void test_buildTree2() {
        assertTreeEquals(exampleTree, exercises.buildTree2(String.join("\n",
                "left(F)=B",
                "left(B)=A",
                "right(B)=D",
                "left(D)=C",
                "right(D)=E",
                "right(F)=G",
                "right(G)=I",
                "left(I)=H")));
        assertTreeEquals(SdaTree.of("root", SdaTree.leaf("only"), null), exercises.buildTree2("left(root)=only"));
        assertTreeEquals(SdaTree.of("root", null, SdaTree.leaf("only")), exercises.buildTree2("right(root)=only"));
        assertThrows(IllegalArgumentException.class, () -> exercises.buildTree2(String.join("\n",
                "left(F)=B",
                "left(X)=Z")));
        assertThrows(IllegalArgumentException.class, () -> exercises.buildTree2(""));
        assertThrows(IllegalArgumentException.class, () -> exercises.buildTree2("left(X)="));
        assertThrows(IllegalArgumentException.class, () -> exercises.buildTree2("left (X)=Z"));
    }

    @Test
    void test_calcHeight() {
        assertEquals(3, exercises.calcHeight(exampleTree));
        assertEquals(2, exercises.calcHeight(exampleTree.getLeftChild().get()));
        assertEquals(0, exercises.calcHeight(SdaTree.leaf("test")));
    }

    @Test
    void test_findMax() {
        assertEquals("I", exercises.findMax(exampleTree, naturalOrder()));
        assertEquals(42, (int) exercises.findMax(SdaTree.leaf(42), naturalOrder()));

        SdaTree<Integer> tree = SdaTree.of(1,
                SdaTree.of(3,
                        null,
                        SdaTree.of(6,
                                null,
                                SdaTree.leaf(10))),
                SdaTree.of(2,
                        SdaTree.of(4,
                                SdaTree.leaf(7),
                                SdaTree.leaf(8)),
                        SdaTree.of(6,
                                null,
                                SdaTree.leaf(9))));

        assertEquals(10, (int) exercises.findMax(tree, naturalOrder()));
        assertEquals(1, (int) exercises.findMax(tree, reverseOrder()));
    }

    private <T> void assertTreeEquals(SdaTree<T> expected, SdaTree<T> actual) {
        assertEquals(print(expected), print(actual));
    }

    private String print(SdaTree<?> tree) {
        return print(tree, "").toString();
    }

    private CharSequence print(SdaTree<?> tree, String indent) {
        StringBuilder sb = new StringBuilder(indent).append(tree.getValue());
        if (tree.getLeftChild().isPresent() || tree.getRightChild().isPresent()) {
            sb.append('\n').append(child(indent, tree.getLeftChild()));
            sb.append('\n').append(child(indent, tree.getRightChild()));
        }
        return sb;
    }

    private CharSequence child(String indent, Optional<? extends SdaTree<?>> child) {
        return child.map(left -> print(left, indent + "  ")).orElse(indent + "  (none)");
    }

}
