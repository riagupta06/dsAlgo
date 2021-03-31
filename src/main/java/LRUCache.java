import java.util.*;

public class LRUCache {

    public static Map<Integer, Integer> map = new HashMap<>();
    public static Deque<Integer> deque = new LinkedList<>();
    public static int capacity;

    public LRUCache(int cap) {
        capacity = cap;
    }

    public static void main(String[] args) {
        System.out.println("Going to test the LRU Cache Implementation");
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10
        cache.put(3, 30);
        System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)
        cache.put(4, 40);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40
    }

    public int get(int key)
    {
        int value;
        if(map.containsKey(key)) {
            value = map.get(key);
            deque.remove(key);
            deque.addFirst(key);
        } else value = -1;
        return value;
    }

    public void put(int key, int value)
    {
        if(deque.contains(key)) {
            deque.remove(key);
        } else if(deque.size() == capacity) {
            int removed = deque.removeLast();
            map.remove(removed);
        }
        deque.addFirst(key);
        map.put(key, value);
    }

}
