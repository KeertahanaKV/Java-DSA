import java.util.*;

public class BFSGraph {
    private int V; // Number of vertices
    private List<List<Integer>> adjList; // Adjacency list

    // Constructor
    public BFSGraph(int vertices) {
        V = vertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edge (undirected graph)
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For directed graph, remove this line
    }

    // BFS traversal from a given start node
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        BFSGraph g = new BFSGraph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        g.bfs(0); // Start BFS from node 0
    }
}
  // // Recursive BFS
  //   private void bfsHelper(Queue<Integer> queue, boolean[] visited) {
  //       if (queue.isEmpty()) return;

  //       int node = queue.poll();
  //       System.out.print(node + " ");

  //       for (int neighbor : adj.get(node)) {
  //           if (!visited[neighbor]) {
  //               visited[neighbor] = true;
  //               queue.offer(neighbor);
  //           }
  //       }

  //       bfsHelper(queue, visited); // recurse on remaining queue
  //   }
