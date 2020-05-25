import java.util.HashMap;
import java.util.Map;
//"used" means "accessed", including both set and get. So in both of your two scenarios, you MUST invalidate (1, 1)

public class LRUCache {

        private int capacity;

        private static HashMap<Integer, Integer[]> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();

        }
        // Get the value (will always be positive) of the key
        // if the key exists in the cache,
        public int get(int key) {
            // increment number of uses
            if(map.containsKey(key)) {
                System.out.println("contains " + key);
                int count = map.get(key)[1];
                int val = map.get(key)[0];
                Integer[] valAndC = {val, count +1};
                map.put(key, valAndC);

                return val;
            }
            return -1;
        }

    /**
     * Set or insert the value if the key is not already present.
     * When the cache reached its capacity, it should invalidate the
     * least recently used item before inserting a new item.
     * @param key
     * @param value
     */
        public void put(int key, int value) {
            // check amount of entries capacity
            if (map.keySet().size() < capacity) {
                System.out.println("Cur map size: " + map.keySet().size());
                // insert
                // check if the key is present
                Integer[] valAndC = {value, 0};
                map.put(key, valAndC);
            } else {
                // invalidate
                // find the least accessed
                System.out.println("Cur map size at or over capacity: " + map.keySet().size());
                Map.Entry<Integer, Integer[]> leastAccessed = findLeastAccessed(map);
                System.out.print("Least accessed " + leastAccessed.getKey() + "access times" + value);
                invalidate(leastAccessed.getKey());
                Integer[] valAndC = {value, 0};
                map.put(key, valAndC);
            }
        }
        //invalidate the least recently used item
        // find the item that was used the least amount of times
        // remove it from map
        // remove it from map
        public void invalidate(int key){
            if(map.containsKey(key)){
                // remove that entry
                map.remove(key);
            }

            // iterate over each keyVal pair and select one with the least amount of uses
            // use remove method to remove that object key.

        }

        public Map.Entry<Integer, Integer[]> findLeastAccessed(HashMap<Integer, Integer[]> map){
            // iterate over map entries and check which one has the least
            //int min = 0;
            // if there is only one item in the map - return that item
            Map.Entry<Integer, Integer[]> leastAccessed = map.entrySet().iterator().next();
            int min = leastAccessed.getValue()[1];
            for(Map.Entry<Integer, Integer[]> entry: map.entrySet()){
                if(entry.getValue()[1] < min){
                    min = entry.getValue()[1];
                    leastAccessed = entry;
                }
            }

            return leastAccessed;
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 *
 */

    public static void main(String[] args){
        LRUCache obj = new LRUCache(3);
//        int param_1 = obj.get(1);
//        System.out.print(param_1);
        obj.put(10,1);
        obj.put(20,2);

        int param_1 = obj.get(20);
        int param_2 = obj.get(20);
        int param_3 = obj.get(20);
        //System.out.print(param_1);
        obj.put(10,1);
        //obj.put(30,3);
        int param_4 = obj.get(10);
        System.out.println("20 was accessed " + map.get(20)[1] + " times");
        System.out.println("10 was accessed " + map.get(10)[1] + " times");
        System.out.println("Least accessed " + obj.findLeastAccessed(map).getKey());

    }
}
