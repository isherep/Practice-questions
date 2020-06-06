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

    Node MergeListsInPlace(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node head;
        if (list1.val < list2.val) {
            head = list1;
        } else {
            head = list2;
            list2 = list1;
            list1 = head;
        }
        while(list1.next != null) {
            if (list1.next.val > list2.val) {
                Node tmp = list1.next;
                list1.next = list2;
                list2 = tmp;
            }
            list1 = list1.next;
        }
        list1.next = list2;
        return head;
    }

    static Node mergeRecursive(Node h1, Node h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        // start with the linked list
        // whose head data is the least
        if (h1.val < h2.val) {
            h1.next = mergeRecursive(h1.next, h2);
            return h1;
        } else {
            h2.next = mergeRecursive(h1, h2.next);
            return h2;
        }
    }

    }
