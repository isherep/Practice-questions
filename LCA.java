public class LCA {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     * This is the case of not BST.
     */


     /*
       Basic idea is to return the node if it is found in any of the subtrees.
       At any node, search for both given nodes in the left subtree.
       If we get a non-empty node returned from the left subtree, there is at least
        one of the two nodes is on left subtree.

        https://algorithmsandme.com/lowest-common-ancestor-in-binary-tree/
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == root || q == root) {
            return root;
        }
        // it recureses down to the left and right subtrees and or root == p or q
        // keeps returning that node up
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // check if left or right are equal p and q
        if (left == p && right == q || left == q && right == p) {
            // return their root;
            return root;
        }

        if (left != null) {
            return left;
        } else {
            return right;
        }

        // if left and right are equal to p or q = that means their root is a lca
    }

    /*
     *  When its BST
     */

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorBST(root.right, p, q);

        } else {
            // if both of these p and q values do not live on the same side -
            //that means that they live on split sides. This means we are currently on tha least commong
            // acestore node
            return root;
        }

    }
}
