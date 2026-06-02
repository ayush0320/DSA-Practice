// Graph of 4 vertices
// 0 ---- 1
// |      |
// |      |
// 2 ---- 3

// -> Adjacency Matrix representation of the above graph
// -> Adjecny Matrix is a 2D array where the value at row i and column j is 1 if there is an edge 
// from vertex i to vertex j, and 0 otherwise.
// -> It is more space-efficient for dense graphs, where the number of edges is close 
// to the square of the number of vertices.
// -> However, it can be less efficient for sparse graphs, 
// where the number of edges is much less than the square of the number of vertices, 
// as it requires O(V^2) space regardless of the number of edges.

//---------------------------------------------------------------------------------------------------

package graphs.implementation;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        int vertices = 4;

        // Create adjacency matrix
        int[][] graph = new int[vertices][vertices];

        // Add edges
        graph[1][0] = 1;
        graph[0][1] = 1;

        graph[0][2] = 1;
        graph[2][0] = 1;

        graph[1][3] = 1;
        graph[3][1] = 1;

        graph[2][3] = 1;
        graph[3][2] = 1;

        // Print matrix
        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();

        }
    }
}
