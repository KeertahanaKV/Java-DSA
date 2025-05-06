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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> li=new ArrayList<>();
        preOrder(root,li);
        return li;
    }
    private void preOrder(TreeNode root, List<Integer> li)
    {
          if(root==null)
          return;

          li.add(root.val);
          preOrder(root.left,li);
          preOrder(root.right,li);
    }
}
