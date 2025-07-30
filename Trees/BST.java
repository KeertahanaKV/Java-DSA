// Definition of the Tree Node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

// Binary Search Tree class
public class BST {
    TreeNode root;

    // Insert a node into the BST
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);

        return root;
    }


     // put(5, 10)
    // put(1005, 20)
    // 5 % 1000 = 5 → goes in index 5
    // 1005 % 1000 = 5 → also index 5 (collision)
    // → Store both in a linked list at index 5.
    // Search for a value in the BST
    public boolean search(TreeNode root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;
        if (key < root.val)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // Inorder Traversal (prints tree in sorted order)
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Main method to test the BST
    public static void main(String[] args) {
        BST tree = new BST();

        // Inserting values into the BST
        int[] values = {10, 5, 15, 3, 7, 12, 18};
        for (int val : values) {
            tree.root = tree.insert(tree.root, val);
        }

        // Printing the BST in sorted order
        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root); // Output: 3 5 7 10 12 15 18

        // Searching for a value
        int searchKey = 7;
        System.out.println("\nIs " + searchKey + " present? " + tree.search(tree.root, searchKey));
    }
}
