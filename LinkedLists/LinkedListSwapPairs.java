public class LinkedListSwapPairs {
    public ListNode swapPairs(ListNode head) {

        // Dummy node acts as the prev for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode first = head;
            ListNode second = head.next;

            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Reinitializing the head and prev for next swap
            prev = first;
            head = first.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }
}
