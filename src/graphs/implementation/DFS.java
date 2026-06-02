// https://youtu.be/59fUtYYz7ZU
// Depth First Traversal of Graph
// -> Go to the deepest neighbour first
// -> Uses stack (Recursion)
// -> Keep goint to the 1st neighbour until you reach a dead end
// -> Visited array - size(vertices)
// Pseudo Code:
// void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
//     1. Get and print curr node
//     2. vis[curr] = true
//     3. for all neighbours of curr node, if neighbour is not visited, call dfs for that neighbour
// }

// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) for the visited array and O(V) for the recursion stack in the worst case,
// resulting in O(V) overall.

// ----------------------------------------------------------------------------------

package graphs.implementation;

import java.util.ArrayList;

public class DFS {
    // Define Edge class
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.println(curr + " ");
        vis[curr] = true;

        // Visit neightbours
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            dfs(graph, e.dest, vis);
        }
    }

    public static void main(String[] args) {
        int v = 7;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        boolean vis[] = new boolean[v];
        dfs(graph, v, vis);
        System.err.println();
    }
}
