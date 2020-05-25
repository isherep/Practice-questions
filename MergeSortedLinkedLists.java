/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of
 * the first two lists.
 */
public class MergeSortedLinkedLists {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // create the head of new list and iterator
            ListNode cur = new ListNode(Integer.MIN_VALUE);
            ListNode newH = cur;
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    // I want to keep the current value in the list and only adding new elements instead of null
                    // in the end of every iteration and at the start - the cur's next pointer is null
                    // and I want to append list contexts to cur. so cur.next = list
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            // now if we came to the end of one list, that means that elements in second list are all larger
            if(l1 != null){
                cur.next = l1;
            }

            if(l2 != null){
                cur.next = l2;
            }

            return newH.next;

        }

}
