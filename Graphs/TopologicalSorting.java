import java.util.*;

public class TopoSortDFS {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Stack<Integer> stack = new Stack<>();
    private Set<Integer> visited = new HashSet<>();

    // Add edge (directed)
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.get(u).add(v);
    }

    // DFS function
    private void dfs(int node) {
        visited.add(node);

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor);
            }
        }
        stack.push(node); // push after visiting all children
    }

    // Topological Sort
    public List<Integer> topologicalSort(int V) {
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                dfs(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        TopoSortDFS graph = new TopoSortDFS();

        graph.addEdge(5, 0);
        graph.addEdge(5, 2);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Topological Sort (DFS): " + graph.topologicalSort(6));
    }
}
