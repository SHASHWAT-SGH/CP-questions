package exam.graphs;

import java.util.*;

/*
A bipartite graph can be colored with two colors such that no two adjacent vertices share the same color.
This means we can divide the graph’s vertices into two distinct sets where:

All edges connect vertices from one set to vertices in the other set.
No edges exist between vertices within the same set.
*/
public class IsGraphBipartite {
    static boolean isBipartite(int V,
                               List<List<Integer> > adj){
        int[] color = new int[V];

        // Initialize all as -1 (uncolored)
        Arrays.fill(color, -1);

        // Iterate through all vertices to handle
        // disconnected graphs
        for (int i = 0; i < V; i++) {

            // If the vertex is uncolored, start BFS from it
            if (color[i] == -1) {

                // Assign first color (0)
                color[i] = 0;
                Queue<Integer> q = new LinkedList<>();

                // Add starting vertex to the queue
                q.offer(i);

                while (!q.isEmpty()) {
                    int u = q.poll();

                    // Traverse all adjacent vertices
                    for (int v : adj.get(u)) {

                        // If the adjacent vertex is
                        // uncolored, assign alternate color
                        if (color[v] == -1) {
                            color[v] = 1 - color[u];

                            q.offer(v);
                        }

                        // If the adjacent vertex has the
                        // same color, graph is not
                        // bipartite
                        else if (color[v] == color[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        // If no conflicts in coloring, graph is bipartite
        return true;
    }

    public static void main(String[] args){
        // Graph Structure:
        // 0 - 1
        // |   |
        // 3 - 2
        int V = 4;
        List<List<Integer> > adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Adding edges (undirected)
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(3); adj.get(3).add(2);
        adj.get(3).add(0); adj.get(0).add(3);

        if (isBipartite(V, adj))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
