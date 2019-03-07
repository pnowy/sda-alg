package pl.sda.programming.day2;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import pl.sda.programming.day2.tasks.SdaBst;
import pl.sda.programming.day2.tasks.Tasks_Bst;

import static org.junit.jupiter.api.Assertions.*;

class Tests_Bst {

    private Tasks_Bst exercises = new Tasks_Bst();

    @Test
    void test_SdaBst_insert() {
        SdaBst<Integer> bst = exercises.createBst(new Integer[]{6, 7, 8, 4, 10, 1, 3, 14, 13});
        assertEquals(Lists.newArrayList(1, 3, 4, 6, 7, 8, 10, 13, 14), bst.toList());
    }

    @Test
    void test_SdaBst_contains() {
        SdaBst<Integer> bst = exercises.createBst(new Integer[]{6, 7, 8, 4, 10, 1, 3, 14, 13});
        assertTrue(bst.contains(8));
        assertTrue(bst.contains(14));
        assertTrue(bst.contains(1));
        assertFalse(bst.contains(2));
        assertFalse(bst.contains(5));
    }

    @Test
    void test_SdaBst_delete() {
        SdaBst<Integer> bst = exercises.createBst(new Integer[]{6, 7, 8, 4, 10, 1, 3, 14, 13});
        bst.delete(3);
        assertEquals(Lists.newArrayList(1, 4, 6, 7, 8, 10, 13, 14), bst.toList());
        bst.delete(8);
        assertEquals(Lists.newArrayList(1, 4, 6, 7, 10, 13, 14), bst.toList());
        bst.delete(6);
        assertEquals(Lists.newArrayList(1, 4, 7, 10, 13, 14), bst.toList());
        bst.delete(3);
        bst.delete(1);
        bst.delete(13);
        bst.delete(14);
        assertEquals(Lists.newArrayList(4, 7, 10), bst.toList());
        bst.delete(4);
        bst.delete(10);
        bst.delete(7);
        assertEquals(Lists.newArrayList(), bst.toList());
    }

}
