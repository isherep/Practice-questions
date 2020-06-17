public class LinkedListsMergeSort {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        // nlogn iis for quicksort and merge sort
        // https://www.youtube.com/watch?v=mM0EVkKraVw
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            // find the middle
            ListNode slow = head;
            ListNode fast = head;
            while(slow.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            //after advanced to the midde of the list, create middle that points to slow
            ListNode mid = slow;
            ListNode newStart = slow.next;
            // break the pointer after middle;
            mid.next = null;

            // break up the right sublist and the left sublist and save their result in the poiters
            ListNode l1 = sortList(head);
            ListNode l2 = sortList(newStart);

            // now after I created nunch of 1 node lists, I need to merge them
            return merge(l1, l2);
        }



        // merge
        public ListNode merge(ListNode l1, ListNode l2){

            // compare their values and switch if needed
            // at first iteration, when lists have only one node each, we can reverse next pointers on those
            // but after seond iteration, each list will have 2 nodes, so we need to
            // compare first ones and than advance pointers and compare next one

            // create empty list node and prev pointer that points to this empty node
            // than compare fist node in a list, if its smaller than first in second list - advance pointer
            // if its larger - set prev next to l2 and advance poiinters.
            ListNode l = new ListNode(Integer.MIN_VALUE), p = l;
            // if both lists are same length
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            // if they are not the same length - advance until they are
            if (l1 != null)
                p.next = l1;

            if (l2 != null)
                p.next = l2;

            return l.next;

        }

}
