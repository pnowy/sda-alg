package pl.sda.programming.day2to5.complexity;

import org.apache.commons.math.stat.descriptive.moment.StandardDeviation;

import java.util.Arrays;

public class Statistics {
    public double average;
    public double median;
    public double stdDev;

    public static Statistics compute(double[] array) {
        double[] sorted = Arrays.stream(array)
                .sorted()
                .toArray();

        double average = Arrays.stream(sorted)
                .average()
                .getAsDouble();

        double median = computeMedian(sorted);

        double stdDev = new StandardDeviation().evaluate(sorted);

        Statistics stats = new Statistics();
        stats.average = average;
        stats.median = median;
        stats.stdDev = stdDev;
        return stats;
    }

    public static double computeMedian(double[] array) {
        Arrays.sort(array);
        double median;
        if (array.length % 2 == 0)
            median = (array[array.length/2] + array[array.length/2 - 1])/2;
        else
            median = array[array.length/2];
        return median;
    }

    public static double[] cutOutsiders(double[] array) {
        Statistics stats = compute(array);

        double[] withoutOutsiders = Arrays.stream(array)
                .filter(x -> x > stats.average - stats.stdDev)
                .filter(x -> x < stats.average + stats.stdDev)
                .toArray();

        return withoutOutsiders;
    }
}
