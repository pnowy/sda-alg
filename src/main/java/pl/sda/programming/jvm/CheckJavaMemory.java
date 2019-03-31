package pl.sda.programming.jvm;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

public class CheckJavaMemory {

    public static void main(String[] args) throws InterruptedException {
        Runtime rt = Runtime.getRuntime();
        long prevTotal = 0;
        long prevFree = rt.freeMemory();

        Map<Integer, NewObject> map = new HashMap<>();
        for (int i = 0; i < 2_000_000; i++) {
            long total = rt.totalMemory();
            long free = rt.freeMemory();
            if (total != prevTotal || free != prevFree) {
                long used = total - free;
                System.out.println(
                        "#" + i +
                                ", Total: " + humanReadableByteCount(total) +
                                ", Used: " + humanReadableByteCount(used) +
                                ", Free: " + humanReadableByteCount(free));
                prevTotal = total;
                prevFree = free;
                //        System.gc();
            }
            Thread.sleep(5);
            map.put(i, new NewObject());
            if (i % 2 == 0) {
                Integer key = map.keySet().iterator().next();
                map.remove(key);
            }
        }

        // long[][] ary = new long[Integer.MAX_VALUE][Integer.MAX_VALUE];
    }

    static String humanReadableByteCount(long bytes) {
        int unit = 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = ("KMGTPE").charAt(exp-1) + ("i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    static class NewObject {
        private final List<Long> longs;

        NewObject() {
            this.longs = new ArrayList<>(1000);
            LongStream.rangeClosed(0, 9999)
                    .map(x -> RandomUtils.nextLong())
                    .forEach(longs::add);
        }
    }
}
