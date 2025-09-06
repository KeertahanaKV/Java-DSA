import java.util.*;

public class TopologicalSortKahn {
    public static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        
        // Step 1: Compute indegree of each node
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        // Step 2: Push all nodes with indegree 0 into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: BFS-like traversal
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            // Decrease indegree of neighbors
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If topoOrder size != V → graph has a cycle (not a DAG)
        if (topoOrder.size() != V) {
            throw new RuntimeException("Graph has a cycle! Topological sort not possible.");
        }

        return topoOrder;
    }

    public static void main(String[] args) {
        // Example: Project Scheduling
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Dependencies (u → v means u must be done before v)
        adj.get(0).add(2); // Design UI → Integrate
        adj.get(1).add(2); // Build Backend → Integrate
        adj.get(2).add(3); // Integrate → Testing
        adj.get(3).add(4); // Testing → Deployment

        List<Integer> order = topoSort(V, adj);

        String[] tasks = {"Design UI", "Build Backend", "Integrate", "Testing", "Deployment"};

        System.out.println("Topological Order of Tasks (Kahn’s Algorithm):");
        for (int task : order) {
            System.out.println(tasks[task]);
        }
    }
}
