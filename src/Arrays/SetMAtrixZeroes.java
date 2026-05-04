public class SetMAtrixZeroes {
    public static void setZeroes(int[][] matrix) {
        // Brute Force Approach
        // int m = matrix.length; // number of rows
        // int n = matrix[0].length; // number of columns

        // // First pass: mark rows and columns
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (matrix[i][j] == 0) {
        // // mark entire row as -1 except zeros
        // for (int col = 0; col < n; col++) {
        // if (matrix[i][col] != 0) {
        // matrix[i][col] = -1;
        // }
        // }
        // // mark
        // for (int row = 0; row < m; row++) {
        // if (matrix[row][j] != 0) {
        // matrix[row][j] = -1;
        // }
        // }
        // }
        // }
        // }

        // // Second pass: replcae -1 with 0
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (matrix[i][j] == -1) {
        // matrix[i][j] = 0;
        // }
        // }
        // }

        // ----------------------------------------------------------------------

        // Better Approach
        // int m = matrix.length; // number of rows
        // int n = matrix[0].length; // number of columns

        // // Create row marker array
        // boolean[] rowMarker = new boolean[m];
        // // Create column marker array
        // boolean[] colMarker = new boolean[n];

        // // First pass: mark rows and columns
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (matrix[i][j] == 0) {
        // rowMarker[i] = true;
        // colMarker[j] = true;
        // }
        // }
        // }

        // // Second pass: set zeroes based on markers
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (rowMarker[i] || colMarker[j]) {
        // matrix[i][j] = 0;
        // }
        // }
        // }

        // ----------------------------------------------------------------------

        // Optimal Approach

    }

    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        setZeroes(matrix);

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
