import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTreeTraversal {

    /**     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    public List<Integer> preorderTraversal(TreeNode node) {

        ArrayList<Integer> l = new ArrayList<>();
        if(node == null){
            return l;
        }

        Stack<TreeNode> s = new Stack<>();
        s.push(node);
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            l.add(cur.val);
            if(cur.right != null){
                s.push(cur.right);
            }
            if(cur.left != null){
                s.push(cur.left);
            }

        }

        return l;

    }

}
