package pl.sda.programming.introduction.shop.utils;

import java.util.List;

public final class ListUtils {

    public static <T> String toNumeratedList(List<T> list) {
        StringBuilder builder = new StringBuilder("\n");
        int i = 1;
        for (T el : list) {
            builder.append(i++).append(". ")
                    .append(el)
                    .append('\n');
        }
        return builder.toString();
    }
}
