package medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {


    int cap = 0;

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);

        System.out.println(lru);
        System.out.println(lru.get(1));


    }

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.cap = capacity;
    }

    public int get(int key) {
        return super.get(key);

    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > cap;
    }
}
