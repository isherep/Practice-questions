import java.util.HashMap;

public class LRU {
    class LRUCache {
        HashMap<Integer, Node> map;
        Node head;
        Node tail;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            Node head = new Node();
            Node tail = new Node();
            // Node head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            // find the nodes value
            int res = -1;
            if(map.containsKey(key)){
                Node n = map.get(key);
                res=n.val;
                // move the node to the end
                remove(n);
                insert(n);

            }

            return res;
        }
        // put cache entry
        // put either adds it or overrides it
        public void put(int key, int value) {
            // put counts as access operation so if the node exists int he map - remove it from back and insert at top
            //. if the node is already in the map - update the value

            Node cur = map.get(key);
            System.out.print(cur==null);
            if(cur!=null){
                // if node exists - update the value in the map
                // and move it to front in the list
                cur.val = value;
                remove(cur);
                insert(cur);
            } else {
                // check if capacity is reached, and if so -
                // remove last node to free 1 space
                if(map.size() >= capacity){
                    // remove the node previous to tail from the hashmap
                    Node last = tail.prev;
                    map.remove(last.key);
                    remove(last);
                }
                // insert the new node
                Node n = new Node();
                n.val = value;
                n.key = key;
                map.put(key, n);
                insert(n);
            }

        }

        public void insert(Node node){
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }
        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next= null;
            node.prev = null;
        }

        public void removeTailNode(){
            if(tail == null) return;
            tail.prev.next = null;
            tail.prev = null;
            tail.next = null;
            // remove pointers from previous node to tail

        }

        public void invalidate(){

            // find the least recently used - it should be at the tail of the list
            // remove it from linked list
            // remove it from the map
        }

        private class Node{
            int key;
            int val;
            Node next;
            Node prev;
        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
