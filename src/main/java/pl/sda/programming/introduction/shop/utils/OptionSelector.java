package pl.sda.programming.introduction.shop.utils;

import java.util.Arrays;
import java.util.List;

public final class OptionSelector<T> {

    private final List<T> options;

    public OptionSelector(List<T> options) {
        this.options = options;
    }

    @SafeVarargs
    public OptionSelector(T ...options) {
        this(Arrays.asList(options));
    }

    public int select() {
        String list = ListUtils.toNumeratedList(options);
        System.out.println(list);
        return ScannerUtils.nextInt(1, options.size());
    }
}