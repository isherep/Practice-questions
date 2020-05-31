import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


    class Solution {
        public Node copyRandomList(Node head) {
            HashMap<Node, Node> map = new HashMap<>();
            Node cur = head;

            while(cur !=null){
                Node clone = new Node(cur.val);
                map.put(cur, clone);
                cur = cur.next;
            }

            for (Map.Entry<Node, Node> entry : map.entrySet()) {
                // save first node as finel
                final Node newNode = entry.getValue();
                // original list next piinter
                Node orNext = entry.getKey().next;
                // get coresponding value clone for the next pointer
                newNode.next = map.get(orNext);
                Node origRan = entry.getKey().random;
                newNode.random = map.get(origRan);
            }
            // the value for key head is it's clone
            return map.get(head);

//            node = head;
//          while (node != null) {
//             map.get(node).next = map.get(node.next);
//             map.get(node).random = map.get(node.random);
//             node = node.next;
//         }

//   return map.get(head);
        }
    }


    public Node copyRandom(Node head){
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<Node, Node>();

        // loop 1. copy all the nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            Node clone = map.get(node);
            // find the originals next pointer's clone
            // set clone's next pointer to it
            // repeat with random
            Node nextClone = map.get(node.next);
            clone.next = nextClone;
            clone.random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
