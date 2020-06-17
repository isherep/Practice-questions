import java.util.*;
/*
* Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

    Example 1:

    Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    Output: 3
    Explanation: The LCA of nodes 5 and 1 is 3.

    https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    // build a table of element and its parents using queue and map
    // put parent nodes of p in a set
    // iterate over the set untill the q is in there, changing q value to it's parent
    // put a path to p or q in a stack and than start with other element checking if its in stack and checkint
    // if it's other parents are in stack.

    So it's like you go up in every parent's node untill that parent is present in  a set
    // that means that parent was already a prent of other node.
 */

public class LCABinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            Map<TreeNode, TreeNode> parent = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            parent.put(root, null);
            queue.add(root);

            // Thuth table -
            //   a         b         a && b (AND)           a || b (OR)
            //  true	false	       false	             true
            while (!parent.containsKey(p) || !parent.containsKey(q)) {
                System.out.println("!parent.containsKey(q):  " + !parent.containsKey(p));
                System.out.println("!parent.containsKey(q):  " + !parent.containsKey(q));
                System.out.println("!parent.containsKey(p) || !parent.containsKey(q): " + (!parent.containsKey(p) ||            !parent.containsKey(q)));
                System.out.println("p is: " + p.val + ", " + !parent.containsKey(p));
                TreeNode node = queue.poll();
                if (node != null) {
                    parent.put(node.left, node);
                    parent.put(node.right, node);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            Set<TreeNode> set = new java.util.HashSet<>();
            while (p != null) {
                set.add(p);
                p = parent.get(p);
            }
            while (!set.contains(q)) {
                q = parent.get(q);
                // at one point queue will be present in a set
                // set element will mean ancestor we look for
            }
            return q;
        }

    }

