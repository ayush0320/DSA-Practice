//https://www.youtube.com/watch?v=lsOOs5J8ycw

// Approach:
// 1. Outer loop runs for times the number of rows
// 2. Identify for every row number,
//    a. how many columns are there
//    b. types of elements to be printed
// 3. Print the pattern

public class Triangle {

    static void pattern1(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------

    static void pattern2(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = n - 1; col >= row; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------

    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------

    static void pattern4(int n) {
        for (int row = 1; row <= 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row : row;
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------

    static void pattern5(int n) {
        for (int row = 1; row <= 2 * n; row++) {

            int totalColsInRow = row > n ? 2 * n - row : row;

            int noOfSpaces = n - totalColsInRow;
            for (int spaces = 0; spaces < noOfSpaces; spaces++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------

    static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            for (int spaces = n; spaces >= row; spaces--) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------

    static void pattern7(int n) {
        int original = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = original - Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int n = 5;
        pattern1(n);
        System.out.println("------------------");
        pattern2(n);
        System.out.println("------------------");
        pattern3(n);
        System.out.println("------------------");
        pattern4(n);
        System.out.println("------------------");
        pattern5(n);
        System.out.println("------------------");
        pattern6(n);
        System.out.println("------------------");
        pattern7(n);
    }
}
