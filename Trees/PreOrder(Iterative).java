class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Go as left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Backtrack to the last valid node
            current = stack.pop();
            result.add(current.val);

            // Move to right subtree
            current = current.right;
        }

        return result;
    }
}
