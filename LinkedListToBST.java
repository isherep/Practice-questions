public class LinkedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode last){
        ListNode slow = head;
        ListNode fast = head;
        if(head==last) return null;

        while(fast!=last&&fast.next!=last){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head,slow);
        root.right = toBST(slow.next,last);
        return root;
    }
}

