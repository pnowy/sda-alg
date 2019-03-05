package pl.sda.programming.introduction;

import java.util.*;

final class _38_CollectionTask {
    public static void main(String[] args) {

        String[] words = "t1   w2 e3 w2 e3 t1 o1 o1 t1 p1 i3 j1 i2 i2 i3 j1 j1 t1 w2 w2".split("\\s+");
        System.out.println(Arrays.toString(words));

        /*
            1. count every word and put into map: key (word) -> count (value).
               print which one is the most frequent.

            2. deduplicate words, sort, and print - use set.

            3. put deduplicated words into queue and then poll them all.
         */

        // 1.

        Map<String, Integer> countWords = new HashMap<>();
        for (String word : words) {
            if (!countWords.containsKey(word)) {
                countWords.put(word, 1);
            } else {
                int value = countWords.get(word);
                countWords.put(word, value + 1);
            }
        }
        System.out.println(countWords);

        // most frequent
        String mostFrequentWord = null;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : countWords.entrySet()) {
            System.out.println(entry);
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }
        System.out.println("most frequent is " + mostFrequentWord);

        // 2.
        Set<String> deduplicatedAndSorted = new TreeSet<>(Arrays.asList(words));
        System.out.println(deduplicatedAndSorted);

        // 3.
        Queue<String> queue = new PriorityQueue<>(deduplicatedAndSorted);
        String word;
        while ((word = queue.poll()) != null) {
            System.out.println(word);
        }
    }
}
