// https://youtu.be/59fUtYYz7ZU
// Ways to implement graphs:
// 1. Adjacency Matrix
// 2. Adjacency List
// 3. Edge List
// 4. 2D Matrix (Implicit Graph)

// -----------------------------------------------------------------------

package graphs.implementation;

import java.util.ArrayList;

public class AdjacencyList {

    // --------------------------- Adjacency List ---------------------------

    // https://youtu.be/59fUtYYz7ZU?t=1152
    // graph = [ArrayList<Edge>, ArrayList<Edge>, ArrayList<Edge>, ArrayList<Edge>]
    // List of lists of edges
    // Size - number of vertices

    // Edge class to represent an edge in the graph
    static class Edge {
        int src;
        int dest;
        int wt;

        // Constructor to initialize the edge
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Method to create a graph using an adjacency list
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize each vertex's list of edges
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));

    }

    // ===========================

    public static void main(String[] args) {
        int v = 4; // number of vertices

        @SuppressWarnings("unchecked") // to suppress unchecked cast warning
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        // print neighbours of '2'
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.dest + " , " + e.wt);
        }
    }
}