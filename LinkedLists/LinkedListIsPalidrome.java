public class LinkedListIsPalidrome {
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

        // reverse second half of a list and compare to first
        // have a fast pointer pointing to the end
        // reverse second half of a list and compare headnodes
        public boolean isPalindrome(ListNode head) {

            if(head == null){
                return true;
            }
            // find out if the list length is even
            // if list length is even - than include the middle node in the comparison [1,2,1] include 2 [1,2] vs [2,1]
            // if odd - the do not include the middle [1,2,2,1] the mid will be first 2 and I don't need to include it             for second half ([1,2] and [2,2,1] won't work)
            ListNode n = head;
            int length = 0;
            while( n!=null){
                n = n.next;
                length ++;
            }

            // find the middle
            // start reversing the list from the mid.next
            // compare reversed lists
            ListNode slow = head;
            ListNode fast = head;
            ListNode lastBefMid = new ListNode(Integer.MIN_VALUE);
            // need to ad condition here for fast.next cannot be null in order to select next element from the middle
            while(slow.next != null && fast.next !=null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode half = new ListNode(Integer.MIN_VALUE);
            // also it is possible to check if fast.next can be null - it means odd length
            // because fast skips two at the time.
            if(length %2 ==0){
                half = slow.next;
            } else {
                half = slow;
            }

            // now reverse the other half first before terminating first part at mid
            ListNode prev = null;
            ListNode next = null;
            ListNode cur = half;
            while(cur != null){
                //save next node in the next var
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                //advance pointers
            }
            half = prev;
            slow.next = null;
            // compare two lists - the chopped at middle original list and the other half
            while(head!=null && half != null){
                if(head.val != half.val){
                    return false;
                }
                head = head.next;
                half = half.next;
            }
            return true;
        }
    }
