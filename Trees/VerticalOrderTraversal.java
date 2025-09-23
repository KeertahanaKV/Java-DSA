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
 import java.util.*;
class Tuple {
    TreeNode node;
    int row; // row index
    int col; // column index
    
    Tuple(TreeNode _node, int _row, int _col) {
        this.node = _node;
        this.row = _row;
        this.col = _col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map to store nodes by column -> row -> min-heap of node values
        // TreeMap ensures columns and rows are sorted automatically
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        // BFS queue to traverse the tree
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0)); // start from root at row=0, col=0
        
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int row = tuple.row;   // row (top to bottom)
            int col = tuple.col;   // column (left to right)
            
            // If column does not exist, create it
            map.putIfAbsent(col, new TreeMap<>());
            
            // If row in this column does not exist, create a min-heap
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            
            // Add the node value to the min-heap at (col, row)
            map.get(col).get(row).offer(node.val);
            
            // Add left and right children to the queue with updated coordinates
            if (node.left != null) {
                q.offer(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }
        
        // Prepare the final output list
        List<List<Integer>> result = new ArrayList<>();
        
        // Traverse columns in order
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            
            // Traverse rows in order (top to bottom)
            for (PriorityQueue<Integer> nodes : rows.values()) {
                // Extract nodes in ascending order if multiple nodes share the same (row, col)
                while (!nodes.isEmpty()) {
                    colList.add(nodes.poll());
                }
            }
            
            // Add the column list to the result
            result.add(colList);
        }
        
        return result;
    }
}
