package pl.sda.programming.introduction;

import pl.sda.programming.introduction.shop.model.Customer;
import pl.sda.programming.introduction.shop.model.Person;

import java.util.ArrayList;
import java.util.List;

final class _29_Generics {

    public static void main(String[] args) {
        // you define list type via generic
        List<Integer> integers = new ArrayList<>();
        // integers.add("test");
        integers.add(12);
        Integer i1 = (Integer) integers.get(0);

        // let's use Pair
        Pair<String, Integer> pair1 = new Pair<>("one", 1);

        Pair<Customer, String> pair2 = new Pair<>(
                new Person("Jan", "Kowalski"),
                "Hello you");

        String oneStr  = pair1.getLeft();
        Integer oneInt = pair1.getRight();


        Box<String> box = new Box<>("SDA");
        System.out.println(box.getValue());
    }
}

class Box<T> {
    T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

class Pair<L, R> {
    private final L left;
    private final R right;

    Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }
}