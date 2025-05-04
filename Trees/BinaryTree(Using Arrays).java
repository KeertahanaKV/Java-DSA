import java.util.*;

public class ArrayBinaryTree {
    int[] tree;
    int size;

    // Constructor to initialize the array with given capacity
    public ArrayBinaryTree(int capacity) {
        tree = new int[capacity];
        size = 0;
    }

    // Insert a node in next available position
    public void insert(int val) {
        if (size >= tree.length) {
            System.out.println("Tree is full!");
            return;
        }
        tree[size++] = val;
    }

    // Inorder traversal: left - root - right
    public void inorder(int index) {
        if (index >= size) return;
        inorder(2 * index + 1); // left child
        System.out.print(tree[index] + " "); // root
        inorder(2 * index + 2); // right child
    }

    // Preorder traversal: root - left - right
    public void preorder(int index) {
        if (index >= size) return;
        System.out.print(tree[index] + " "); // root
        preorder(2 * index + 1); // left child
        preorder(2 * index + 2); // right child
    }

    // Postorder traversal: left - right - root
    public void postorder(int index) {
        if (index >= size) return;
        postorder(2 * index + 1); // left child
        postorder(2 * index + 2); // right child
        System.out.print(tree[index] + " "); // root
    }

    // Search for a value in the array
    public boolean search(int val) {
        for (int i = 0; i < size; i++) {
            if (tree[i] == val) return true;
        }
        return false;
    }

    // Print the tree as an array
    public void printTree() {
        System.out.print("Tree as array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    // Main method to run and test the tree
    public static void main(String[] args) {
        ArrayBinaryTree bt = new ArrayBinaryTree(15); // capacity of 15 nodes

        // Insert values
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        bt.insert(6);
        bt.insert(7);

        // Print the array form
        bt.printTree();

        // Traversals
        System.out.print("Inorder Traversal: ");
        bt.inorder(0);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        bt.preorder(0);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        bt.postorder(0);
        System.out.println();

        // Search
        System.out.println("Search 5: " + bt.search(5));
        System.out.println("Search 10: " + bt.search(10));
    }
}
