// Breadth-First Search (BFS)
// https://youtu.be/59fUtYYz7ZU

// Breath First Traversal of Graph
// -> Go to immediate neighbour first
// -> Indirect level order traversal
// -> Uses queue
// -> Visited array - size(vertices)

// Pseudo Code:
// while(queue is not empty){
//     int curr = q.remove();
//     if(vis[curr] == false) {
//         1. Get and print curr node
//         2. vis[curr] = true
//         3. add curr node neighbours in queue
//    }
// }

// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V) for the visited array and O(V) for the queue in the worst case, resulting in O(V) overall.

// ----------------------------------------------------------------------------------

package graphs.implementation;

import java.util.*;

public class BFS {

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

    public static void bfs(ArrayList<Edge> graph[], int v) {
        Queue<Integer> q = new LinkedList<>(); // Queue to store nodes to be visited
        boolean[] vis = new boolean[v]; // Array to keep track of visited nodes

        q.add(0); // Start BFS from the first vertex (0)

        // Loop until the queue is empty
        while (!q.isEmpty()) {
            int curr = q.remove();

            if (vis[curr] == false) {
                System.out.println(curr + " ");
                vis[curr] = true;

                // Visit neighbours
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }

    public static void main(String[] args) {
        int v = 7;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        bfs(graph, v);
    }
}
