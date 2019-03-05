package pl.sda.programming.introduction;

import java.util.*;

final class _37_Maps {
    public static void main(String[] args) {
        /*
            Maps are:
            - key-value based data structures
            - equals and hashcode are very important!
            - no guarantee for ordering
            - distinct (keys)
            - inserting/retrieving/removing elements via keys

            Implementations:
            - HashMap (not-ordered)
            - LinkedHashMap (ordered via keys)
            - TreeMap (sorted via keys - using Comparator)
         */

        Map<String, Double> hashMap = new HashMap<>();
        hashMap.put("n1", 1.00);
        hashMap.put("n2", 4.12);
        hashMap.put("n3", 5.23);
        hashMap.put("n102", 10.00);
        hashMap.put("n9292", 34.00);
        hashMap.put("n232002", 12.00);
        System.out.println(hashMap);

        Map<String, Double> linkedMap = new LinkedHashMap<>(hashMap);
        linkedMap.put("n33", 5.66);
        linkedMap.put("n12", 45.33);
        linkedMap.put("n1", 2.00);
        System.out.println(linkedMap);

        System.out.println(linkedMap.get("n2"));

        Map<String, Double> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1.compareTo(o2));
            }
        });
        treeMap.putAll(linkedMap);
        System.out.println(treeMap);

        System.out.println(treeMap.get("not existing key"));

        System.out.println(treeMap.containsKey("n3"));
        System.out.println(treeMap.containsValue(2.00));

        if (treeMap.containsValue(2.00)) {
            // example how to iterate over entries in map
            for (Map.Entry<String, Double> entry : treeMap.entrySet()) {
                System.out.println(entry);
            }
        }
    }
}
