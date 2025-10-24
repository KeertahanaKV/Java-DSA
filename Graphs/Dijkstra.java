import java.util.*;

class Pair {
    int vertex, weight;
    Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Dijkstra {
    public static void dijkstra(int V, List<List<Pair>> adj, int src) {
        int[] dist = new int[V];             // distance array
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;                       // distance to source = 0

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.vertex;

            // Explore neighbors
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // If shorter path found
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Add edges: (u -> v, weight)
        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(2, 4));
        adj.get(1).add(new Pair(2, 1));
        adj.get(1).add(new Pair(3, 7));
        adj.get(2).add(new Pair(4, 3));
        adj.get(3).add(new Pair(4, 1));

        dijkstra(V, adj, 0);
    }
}
