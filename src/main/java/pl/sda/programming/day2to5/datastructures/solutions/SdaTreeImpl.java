package pl.sda.programming.day2to5.datastructures.solutions;

import pl.sda.programming.day2to5.datastructures.tasks.SdaTree;

import java.util.Objects;
import java.util.Optional;

public class SdaTreeImpl<T> implements SdaTree<T> {

    private final T value;
    private final SdaTree<T> left;
    private final SdaTree<T> right;

    public SdaTreeImpl(T value, SdaTree<T> left, SdaTree<T> right) {
        this.value = Objects.requireNonNull(value, "value must not be null");
        this.left = left;
        this.right = right;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public Optional<SdaTree<T>> getLeftChild() {
        return Optional.ofNullable(left);
    }

    @Override
    public Optional<SdaTree<T>> getRightChild() {
        return Optional.ofNullable(right);
    }

}
