package pl.sda.programming.junit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheLib {
    private Map<String, String> cache = new ConcurrentHashMap<>();

    String getFromCache(String key) {
        return cache.get(key);
    }
}
