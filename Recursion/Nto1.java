public class Nto1 {

    static void printNto1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printNto1(n - 1); // Tail Recursion
    }

    static int sumOfN(int n) {
        if (n == 0) {
            return 0;
        }

        return n + sumOfN(n - 1);
    }

    static int SumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 10 + SumOfDigits(n / 10);
    }

    static int ProdOfDigits(int n) {
        if (n % 10 == n) {
            return n; // Base case: if n is a single digit, return n
        }

        return n % 10 * ProdOfDigits(n / 10);
    }

    // concept --n vs n--
    static void fun(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        fun(n--); // Post-decrement - stack overflow due to infinite recursion
        fun(--n); // Pre-decrement
    }

    static void rev1(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n % 10 + " ");
        rev1(n / 10);
    }

    static int rev2(int n) {
        int digits = (int) (Math.log10(Math.abs(n)) + 1); // Calculate the number of digits in n
        return revHelper(n, digits);
    }

    static int revHelper(int n, int digits) {
        if (n % 10 == n) {
            return n; // Base case: if n is a single digit, return n
        }
        int rem = n % 10; // Get the last digit
        // 1234 -> 4 * 10^(4-1) + helper(123, 3) -> 4 * 1000 + helper(123, 3)
        return rem * (int) (Math.pow(10, digits - 1)) + revHelper(n / 10, digits - 1);
    }

    static boolean palindromeNum(int n) {
        return (n == rev2(n));
    }

    static int count(int n) {
        return countHelper(n, 0);
    }

    static int countHelper(int n, int c) {
        if (n == 0) {
            return c;
        }

        int rem = n % 10;
        if (rem == 0) {
            return countHelper(n / 10, c + 1);
        }
        return countHelper(n / 10, c);
    }

    public static void main(String[] args) {
        // printNto1(10); // Example usage
        // System.out.println("\n" + sumOfN(4));
        // System.out.println(SumOfDigits(1234));
        // System.out.println(ProdOfDigits(1234));
        rev1(1234);
        System.out.println("\n" + palindromeNum(12321));
        System.out.println(count(102030));
    }
}
