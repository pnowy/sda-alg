package pl.sda.programming.day2to5.searching;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Solutions_Searching implements Task_Searching {
    @Override
    public int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int binarySearch(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = (low + high) >>> 1; // http://research.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Override
    public <T> Optional<Integer> indexOf(List<T> list, T value, Comparator<T> comparator) {
        if (list.isEmpty()) {
            return Optional.empty();
        }

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (comparator.compare(list.get(mid), value) > 0) {
                high = mid - 1;
            } else if (comparator.compare(list.get(mid), value) < 0) {
                low = mid + 1;
            } else {
                return Optional.of(mid);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<IntRange> binarySearchRange(int[] array, int value) {
        int start = findBoundary(array, value, Boundary.START);
        return start == -1
                ? Optional.empty()
                : Optional.of(new IntRange(start, findBoundary(array, value, Boundary.END)));
    }

    private int findBoundary(int[] array, int value, Boundary boundary) {
        if (array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else if (boundary == Boundary.START && mid > 0 && array[mid - 1] == array[mid]) {
                high = mid - 1;
            } else if (boundary == Boundary.END && mid < array.length - 1 && array[mid + 1] == array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private enum Boundary {
        START, END
    }

    @Override
    public int interpolationSearch(int[] array, int value) {
        if (array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;

        while (low < high && value >= array[low] && value <= array[high]) {
            int mid = low + (high - low) * (value - array[low]) / (array[high] - array[low]);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return value == array[low] ? low : -1;
    }
}
