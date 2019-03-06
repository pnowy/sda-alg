package pl.sda.programming.day2;

import org.junit.jupiter.api.Test;
import pl.sda.programming.day2.solutions.Solutions_Map;
import pl.sda.programming.day2.tasks.domain.Patient;
import pl.sda.programming.day2.tasks.domain.Pesel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class Tests_Maps {


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

        [ Hashtable vs HashMap ]
         - hashtable is synchronized, whereas HashMap is not
         - hashtable does not allow null keys or values. HashMap allows one null key and any number of null values.
         - one of HashMap's subclasses is LinkedHashMap, so in the event that you'd want predictable iteration order (which is insertion order by default),
           you could easily swap out the HashMap for a LinkedHashMap. This wouldn't be as easy if you were using Hashtable.
     */
    @Test
    void variousTypesOfMaps() {
        // implementation - buckets
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("John Smith", "value1");
        hashMap.put("Lisa Smith", "value3");
        hashMap.put("Sandra Dee", "value2");

        System.out.println(hashMap);

        // implementation - duble-linked buckets
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("John Smith", "value1");
        linkedHashMap.put("Lisa Smith", "value3");
        linkedHashMap.put("Sandra Dee", "value2");

        System.out.println(linkedHashMap);

        // implementation - Red-Black Tree
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("Lisa Smith", "value3");
        treeMap.put("John Smith", "value1");
        treeMap.put("Sandra Dee", "value2");

        System.out.println(treeMap);
    }

    @Test
    void patientRegistry() {
        Solutions_Map registry = new Solutions_Map();
        registry.add(new Patient(new Pesel("87062311445"), "Janek"));
        registry.add(new Patient(new Pesel("88062311445"), "Janek"));

        System.out.println(registry.size());
    }

}
