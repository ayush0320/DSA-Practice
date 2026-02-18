// LC 509. Fibonacci Number

public class Fibonacci {

    // Iterative approach
    // Time complexity: O(n)
    // Space complexity: O(1)

    static int fib(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1, c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // ------------------------------------------------------------------------

    // Recursive approach
    // Time complexity: O(2^n) - Exponential time complexity due to repeated
    // calculations
    // Space complexity: O(n) - Due to the call stack in recursion

    static int fibR(int n) {
        if (n <= 1)
            return n;

        return fibR(n - 1) + fibR(n - 2);
    }

    // ------------------------------------------------------------------------

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibR(n));
    }
}
