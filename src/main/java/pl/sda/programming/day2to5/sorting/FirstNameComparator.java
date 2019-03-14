package pl.sda.programming.day2to5.sorting;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.first_name.compareTo(o2.first_name);
    }
}
