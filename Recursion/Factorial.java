public class Factorial {

    static int factorial(int n) {
        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(factorial(num));
    }
}
