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
}
