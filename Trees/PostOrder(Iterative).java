class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;

        while (current != null || !stack.isEmpty()) {
            // 1. Go as left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 2. Peek the node at the top of the stack
            TreeNode top = stack.peek();

            // 3. If right is null OR right already visited
            if (top.right == null || top.right == prev) {
                result.add(top.val);  // process the node
                stack.pop();
                prev = top;           // mark as visited
            } else {
                // 4. Otherwise, go to right subtree
                current = top.right;
            }
        }

        return result;
    }
}
