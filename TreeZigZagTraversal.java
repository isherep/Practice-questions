import java.util.*;

public class TreeZigZagTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean level = false; // the number of level !!
            while(!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                while(size > 0) {
                    TreeNode node = queue.poll();
                    // you can do here
                    // check if level is even - jsut add
                    // if add - add in at the first position
                    list.add(node.val);
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                    size--;
                }

                if(level) { // if odd level - reverse data
                    Collections.reverse(list);
                }
                res.add(list);

                level = !level; // after traverse all member of element in same level, go next level
            }
            return res;
        }
}
