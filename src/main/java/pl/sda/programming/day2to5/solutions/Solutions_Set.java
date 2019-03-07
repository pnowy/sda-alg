package pl.sda.programming.day2to5.solutions;

import pl.sda.programming.day2to5.tasks.Tasks_Set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solutions_Set implements Tasks_Set {
    @Override
    public <T> Set<T> findDuplicates(List<T> values) {
        Set<T> all = new HashSet<>();
        Set<T> duplicates = new HashSet<>();
        for (T value : values) {
            boolean isAdded = all.add(value);
            if (!isAdded) {
                duplicates.add(value);
            }
        }
        return duplicates;
    }

    @Override
    public <T> Set<T> findCommonValues(List<T> list1, List<T> list2) {
        Set<T> intersection = new HashSet<>(list1);
        intersection.retainAll(list2);
        return intersection;
    }
}
