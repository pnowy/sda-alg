package pl.sda.programming.day1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Task2 {

    /**
     * Napisz program który dla liczby N obliczy sumę wszystkich wielokrotności 3 i 5 które są <= N (mniejsze lub równe)
     */
    @Test
    void task() {
        System.out.println(sum3And5TillV1(10));
    }

    public static int sum3And5TillV1(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
            if (i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int sum3And5TillV2(int n) {
        int sum = 0;
        int multiplesOf3 = 0;
        int i = 0;
        while (multiplesOf3 <= n) {
            sum += multiplesOf3;
            i++;
            multiplesOf3 = i * 3;
        }

        i = 0;
        int multiplesOf5 = 0;
        while (multiplesOf5 <= n) {
            sum += multiplesOf5;
            i++;
            multiplesOf5 = i * 5;
        }

        return sum;
    }

    public static int sum3And5TillV3(int n) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i <= n ; i++) {
            if(i % 3 == 0) {
                numbers.add(i);
            }
            if(i % 5 == 0) {
                numbers.add(i);
            }
        }
        int sum = numbers.stream().mapToInt(x -> x).sum();
        return sum;
    }

    public static int sum3And5TillV4(int n) {
        int sum = IntStream.rangeClosed(1, n)
                .filter(x -> x % 3 == 0 || x % 5 == 0)
                .sum();
        return sum;
    }

}
