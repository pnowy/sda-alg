package pl.sda.programming.day2to5.complexity.compareSearchTime;

import pl.sda.programming.day2to5.complexity.Statistics;
import pl.sda.programming.day2to5.complexity.Utils;

import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        // jitting
        TestResultWithStats[] lostResult = runTestForInputOfSize(100, 2, 3);

        System.out.printf("%s\t%s\t%s\t%s\t%s\n",
                "integers count",
                "array.contains() [ms]",
                "binary_search_tree.contains() [ms]",
                "array.contains() measures count without outsiders",
                "binary_search_tree.contains.contains() measures count without outsiders");
        for (int i = 10000; i < 100000000; i+=10000) {
            TestResultWithStats[] results = runTestForInputOfSize(i, 40, 10 );
            for (TestResultWithStats result : results) {
                System.out.printf("%d\t%.10f\t%.10f\t%d\t%d\n",
                        i,
                        result.arrayStatsNoOutsiders.median,
                        result.bstStatsNoOutsiders.median,
                        result.arrayTimesNoOutsiders.length,
                        result.bstTimesNoOutsiders.length);
            }
        }
    }

    private static TestResultWithStats[] runTestForInputOfSize(int size, int repeatTestCount, int repeatSizeCount) {
        Random random = new Random(System.nanoTime());

        TestResultWithStats[] results = new TestResultWithStats[repeatSizeCount];
        for (int i = 0; i < repeatSizeCount; i++) {
            Integer[] array = Utils.randomArray(size);
            Integer toBeFound = random.nextInt();
            results[i] = runTest(array, toBeFound, repeatTestCount);
        }

        return results;
    }

    private static TestResultWithStats runTest(Integer[] array, Integer toBeFound, int repeatTestCount) {
        TestResult[] results = new TestResult[repeatTestCount];
        for (int i = 0; i < repeatTestCount; i++) {
            TestResult result = runTest(array, toBeFound);
            results[i] = result;
        }

        double[] arrayTimes = Arrays.stream(results)
                .mapToDouble(x -> x.timeForArrayMilliSeconds)
                .sorted()
                .toArray();

        double[] bstTimes = Arrays.stream(results)
                .mapToDouble(x -> x.timeForBstMilliSeconds)
                .sorted()
                .toArray();

        Statistics statsForArray = Statistics.compute(arrayTimes);
        Statistics statsForBst = Statistics.compute(bstTimes);

        double[] arrayTimesNoOutsiders = Statistics.cutOutsiders(arrayTimes);
        double[] bstTimesNoOutsiders = Statistics.cutOutsiders(bstTimes);

        Statistics arrayStatsNoOutsiders = Statistics.compute(arrayTimesNoOutsiders);
        Statistics bstStatsNoOutsiders = Statistics.compute(bstTimesNoOutsiders);

        TestResultWithStats result = new TestResultWithStats();
        result.arrayTimes = arrayTimes;
        result.bstTimes = bstTimes;
        result.arrayTimesNoOutsiders = arrayTimesNoOutsiders;
        result.bstTimesNoOutsiders = bstTimesNoOutsiders;
        result.arrayStats = statsForArray;
        result.bstStats = statsForBst;
        result.arrayStatsNoOutsiders = arrayStatsNoOutsiders;
        result.bstStatsNoOutsiders = bstStatsNoOutsiders;

        return result;
    }

    private static TestResult runTest(Integer[] array, int toBeFound) {
        BstTree bst = new BstTree();
        for (Integer i : array) {
            bst.insert(i);
        }

        long before = System.nanoTime();
        boolean foundInArray = findInArray(array, toBeFound);
        long after = System.nanoTime();
        long elapsedNanoSeconds = after - before;
        double timeForArray = Utils.nanoToMilliSeconds(elapsedNanoSeconds);

        before = System.nanoTime();
        boolean foundInBst = findInBst(bst, toBeFound);
        after = System.nanoTime();
        elapsedNanoSeconds = after - before;
        double timeForBst = Utils.nanoToMilliSeconds(elapsedNanoSeconds);
        if (foundInArray != foundInBst) {
            throw new RuntimeException("something is clearly wrong");
        }

        TestResult result = new TestResult();
        result.timeForArrayMilliSeconds = timeForArray;
        result.timeForBstMilliSeconds = timeForBst;
        return result;
    }

    private static boolean findInBst(BstTree bst, int toBeFound) {
        return bst.contains(toBeFound);
    }

    private static boolean findInArray(Integer[] array, Integer toBeFound) {
        for (int j = 0; j < array.length; j++) {
            if(array[j].equals(toBeFound)) {
                return true;
            }
        }
        return false;
    }
}
