import java.util.*;
import java.util.Map.Entry;

public class LRUCacheOpti {

    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCacheOpti(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity, 0.75f);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);          
            map.put(key, value);
            return;
        } else {
            if (map.size() == capacity) {
                Entry<Integer, Integer> entryToRemove = map.entrySet().iterator().next();
                map.remove(entryToRemove.getKey());
            }
            map.put(key, value);
            return;
        }
    }


    public static void main(String[] args) {

        LRUCacheOpti lRUCache = new LRUCacheOpti(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));

    }

//    public static void main(String[] args) {
//
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1);
//        lRUCache.put(2, 2);
//        System.out.println(lRUCache.get(1));    // return 1
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        System.out.println(lRUCache.get(2));    // returns -1 (not found)
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        System.out.println(lRUCache.get(1));    // return -1 (not found)
//        System.out.println(lRUCache.get(3));    // return 3
//        System.out.println(lRUCache.get(4));    // return 4
//
//    }
}
