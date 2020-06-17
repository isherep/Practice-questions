public class LinkedListReverseKNodes {

    /**
     * 1-2-3-4-5-6-7-8-9
     * 3-2-1-6-5-4-9-8-7
     *
     * @param head
     * @param k
     */
    public static void reverseKNodes(ListNode head, int k){
        // assuming that k is smaller than length
        if(k <= 0){
            return;
        }

        int count = 0;
        ListNode cur = head;
        ListNode headPointer = null;
        ListNode Kth = new ListNode(Integer.MIN_VALUE);

        while(cur.next != null){
            // find Kth node position
            // reverse
            // set count to 0
            ListNode prev = new ListNode(Integer.MIN_VALUE);
            ListNode n = new ListNode(Integer.MIN_VALUE);
            while(count < k){
                // reverse nodes
                n = cur.next;
                cur.next = prev;
                prev = cur;
                cur=n;
                //head = prev;
                count++;
            }
            prev.next = cur; // ends at prev = 3, cur == 4
            count = 0;
            cur = cur.next;

        }

    }
    public static void main(String[] args){
        ListNode n = new ListNode(1);
        ListNode cur = n;
        for(int i = 2; i<=6; i++ ){
            cur.next = new ListNode(i);
            cur=cur.next;
        }

        reverseKNodes(n, 3);

        while(n!=null){
            System.out.print(n.val + " , ");
            n = n.next;
        }

        System.out.print(n);
    }

}
