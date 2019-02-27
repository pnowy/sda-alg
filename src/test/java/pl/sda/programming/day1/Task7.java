package pl.sda.programming.day1;

import java.util.*;

public class Task7 {

    /**
     * Napisz program który jako argument wejściowy (String[] args) przyjmie liczby oddzielone spacjami i następnie:
     * - wypisze wszystkie liczby w kolejności w jakiej zostały podane
     * - wypisze wszystkie liczby od tyłu
     * - wypisze wszystkie na nieparzystych pozycjach
     * - wypisze wszystkie podzielne przez 3
     * - wypisze sumę wszystkich
     * - wypisze sumę pierwszych 4
     * - wypisze sumę ostatnich 5 liczb które są większe niż 2
     * - wypisze sumę liczb od początku tablicy która przekracza 10 (in: "1 2 3 5 6 7 10 100 123" out: "11")
     * - (zadanie domowe) wybierz liczby z tablicy tak by ich suma była jak najbliższa 10, wypisz te liczby
     * - (zadanie domowe) wybierz liczby z tablicy tak by ich suma była jak najbliższa N, wypisz te liczby wejście będzie podane w formie: "N 1 2 13 100 4 10..."
     */

    public static void main(String[] args) {

        args = new String[]{"2", "7", "9", "12", "15"};

        // p1
        System.out.println("all numbers as given input:");
        for (String numberAsText : args) {
            System.out.print(numberAsText + " ");
        }
        System.out.println();

        // p2
        System.out.println("all numbers reversed:");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[args.length - i - 1] + " ");
        }
        System.out.println();

        // p3
        System.out.println("all numbers on odd positions:");
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 1) {
                System.out.print(args[i] + " ");
            }
        }
        System.out.println();

        // p4
        System.out.println("all numbers dividable by 3:");
        for (int i = 0; i < args.length; i++) {
            int parsedInt = Integer.parseInt(args[i]);
            if (parsedInt % 3 == 0) {
                System.out.print(args[i] + " ");
            }
        }
        System.out.println();

        // p5
        System.out.println("sum of all numbers");
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            int parsedInt = Integer.parseInt(args[i]);
            sum += parsedInt;
        }
        System.out.println(sum);
        // using streams:
        // int sum = Arrays.stream(args).mapToInt(x -> Integer.parseInt(x)).sum();


        // p6
        System.out.println("sum of first 4 numbers");
        int sumOfFirst4 = 0;
        for (int i = 0; i < 4; i++) {
            int parsedInt = Integer.parseInt(args[i]);
            sumOfFirst4 += parsedInt;
        }
        System.out.println(sumOfFirst4);
        // using streams:
        // int sum4 = Arrays.stream(args).limit(4).mapToInt(x -> Integer.parseInt(x)).sum();

        // p7
        System.out.println("sum of last 5 numbers greater than 2");
        int sumOfLast5 = 0;
        int count = 0;
        for (int i = args.length - 1; i > 0; i--) { // reverse loop
            int number = Integer.parseInt(args[i]);
            if (number > 2) {
                sumOfLast5 += number;
                count++;
            }
            if (count == 5) {
                break;
            }
        }
        System.out.println(sumOfLast5);
        // using streams:
        int sum5 = Arrays.stream(args)
                .map(Integer::parseInt)
                .filter(x -> x > 2)
                .sorted(Collections.reverseOrder())
                .limit(5)
                .mapToInt(x -> Integer.parseInt(String.valueOf(x)))
                .sum();
        System.out.println(sum5);

        // p8
        System.out.println("Sum numbers from beginning till they reach 10");
        int sum8 = 0;
        for (String s : args) {
            int parsed = Integer.parseInt(s);
            sum8 += parsed;
            if (sum8 >= 10) {
                break;
            }
        }
        System.out.println(sum8);

        findClosestSubSet(10, new int[]{1, 2});
        findClosestSubSet(10, new int[]{1, 2, 3});
        findClosestSubSet(10, new int[]{1, 2, 3, 4});
        findClosestSubSet(10, new int[]{1, 2, 3, 4, 5});
        findClosestSubSet(10, new int[]{1, 2, 3, 4, 5, 6});
        findClosestSubSet(10, new int[]{1, 2, 3, 4, 5, 6, 7});
        findClosestSubSet(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        findClosestSubSet(10, new int[]{1, 2, 3, 10, 11, 20, 33, 43, 123});
        findClosestSubSet(10, new int[]{1, 2, 3, 23, 11, 20, 33, 43, 123, 5, 6, 7});
        findClosestSubSet(37, new int[]{1, 2, 3, 23, 11, 20, 33, 43, 123, 5, 6, 7});
        findClosestSubSet(23, new int[]{4, 1, 100, 23, 11, 20, 33, 43, 123, 7});
    }

    private static void findClosestSubSet(int n, int[] input) {
        List<List<Integer>> subsets = getPowerSet(input);
        List<Integer> closest = subsets
                .stream()
                .sorted(Comparator.comparingInt(x -> Math.abs(n - x.stream().mapToInt(y -> y).sum())))
                .findFirst()
                .get();
        int sumOfClosestSubset = closest.stream().mapToInt(y -> y).sum();
        System.out.print("n=" + n + " sum(subset)=" + sumOfClosestSubset);
        System.out.println(" subset=" + setToString(closest));
    }

    private static String setToString(List<Integer> subset) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i : subset) {
            sb.append(i);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static List<List<Integer>> getPowerSet(int[] elements) {
        List<List<Integer>> powerSet = new ArrayList<>();
        double powerSetCount = Math.pow(2, elements.length) - 1;
        for (int i = 1; i <= powerSetCount; i++) {

            List<Integer> currentSubSet = new ArrayList<>();
            for (int k = 0; k < elements.length; k++) {
                if ((i >> k) % 2 == 1) {
                    currentSubSet.add(elements[k]);
                }
            }
            powerSet.add(currentSubSet);
        }

        return powerSet;
    }

}
