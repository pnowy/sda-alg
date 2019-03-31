package pl.sda.programming.junit;

import java.util.HashMap;
import java.util.Map;

public class Db {
    private Map<String, String> values = new HashMap<>();

    public void put(String key, String value) {
        this.values.put(key, value);
    }

    public int size() {
        return this.values.size();
    }

    public void clear() {
        this.values.clear();
    }

}
