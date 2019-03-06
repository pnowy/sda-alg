package pl.sda.programming.day2;

import org.junit.jupiter.api.Test;
import pl.sda.programming.day2.solutions.Solutions_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Tests_Set {

    @Test
    void setExamples() {

        Set<String> example = new HashSet<>();
        example.add("przemek");
        boolean isAddedFirstTime = example.add("sda");
        System.out.println(isAddedFirstTime);
        boolean isAddedSecondTime = example.add("sda");
        System.out.println(isAddedSecondTime);


        System.out.println(example.size());
    }

    @Test
    void tasks() {
        Solutions_Set solution = new Solutions_Set();

        Set<String> commonValues = solution.findCommonValues(Arrays.asList("sda", "pn"), Arrays.asList("wk", "pn", "sdd"));
        System.out.println(commonValues);
    }
}
