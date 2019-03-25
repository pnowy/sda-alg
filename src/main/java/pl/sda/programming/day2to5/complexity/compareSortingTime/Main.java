package pl.sda.programming.day2to5.complexity.compareSortingTime;


import pl.sda.programming.day2to5.complexity.Statistics;
import pl.sda.programming.day2to5.complexity.Utils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // jitting
        SortingTestResultWithStats[] lostResult = runTestForInputOfSize(100, 2, 3);

        System.out.printf("%s\t%s\t%s\n",
                "integers count",
                "bubble sort [ms]",
                "java sort [ms]");
        for (int i = 100; i < 100000000; i+=100) {
            SortingTestResultWithStats[] results = runTestForInputOfSize(i, 10, 5 );
            for (SortingTestResultWithStats result : results) {
                System.out.printf("%d\t%.10f\t%.10f\n",
                        i,
                        result.bubbleStatsNoOutsiders.median,
                        result.javaSortStatsNoOutsiders.median);
            }
        }
    }

    private static SortingTestResultWithStats[] runTestForInputOfSize(int size, int repeatTestCount, int repeatSizeCount) {
        SortingTestResultWithStats[] results = new SortingTestResultWithStats[repeatSizeCount];
        for (int i = 0; i < repeatSizeCount; i++) {
            int[] array = Utils.randomIntArray(size);
            results[i] = runTest(array, repeatTestCount);
        }
        return results;
    }

    private static SortingTestResultWithStats runTest(int[] array, int repeatTestCount) {
        TestResult[] results = new TestResult[repeatTestCount];
        for (int i = 0; i < repeatTestCount; i++) {
            TestResult result = runTest(array);
            results[i] = result;
        }

        double[] bubbleTimes = Arrays.stream(results)
                .mapToDouble(x -> x.timeForBubble)
                .sorted()
                .toArray();

        double[] javaSortTimes = Arrays.stream(results)
                .mapToDouble(x -> x.timeForJavaSort)
                .sorted()
                .toArray();

        double[] bubbleTimesNoOutsiders = Statistics.cutOutsiders(bubbleTimes);
        double[] javaSortTimesNoOutsiders = Statistics.cutOutsiders(javaSortTimes);

        Statistics bubbleStatsNoOutsiders = Statistics.compute(bubbleTimesNoOutsiders);
        Statistics javaSortStatsNoOutsiders = Statistics.compute(javaSortTimesNoOutsiders);

        SortingTestResultWithStats result = new SortingTestResultWithStats();
        result.bubbleStatsNoOutsiders = bubbleStatsNoOutsiders;
        result.javaSortStatsNoOutsiders = javaSortStatsNoOutsiders;

        return result;
    }

    private static TestResult runTest(int[] array) {
        int[] clone1 = array.clone();
        int[] clone2 = array.clone();

        long before = System.nanoTime();
        bubbleSort_optimized(clone1);
        long after = System.nanoTime();
        long elapsedNanoSeconds = after - before;
        double timeForBubble = Utils.nanoToMilliSeconds(elapsedNanoSeconds);

        before = System.nanoTime();
        sort_from_java(clone2);
        after = System.nanoTime();
        elapsedNanoSeconds = after - before;
        double timeForJavaSort = Utils.nanoToMilliSeconds(elapsedNanoSeconds);

        TestResult result = new TestResult();
        result.timeForBubble = timeForBubble;
        result.timeForJavaSort = timeForJavaSort;
        return result;
    }

    public static void bubbleSort_optimized(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j] > array[j+1]) {
                    swap(j, j+1, array);
                }
            }
        }
    }

    public static void swap(int j, int i, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort_from_java(int[] array) {
        Arrays.sort(array);
    }
}
