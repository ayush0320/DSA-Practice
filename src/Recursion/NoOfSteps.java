public class NoOfSteps {

    static int count(int n) {
        return countHelper(n, 0);
    }

    static int countHelper(int n, int c) {
        if (n == 0) {
            return c;
        }
        if (n % 2 == 0) {
            return countHelper(n / 2, c + 1);
        }
        return countHelper(n - 1, c + 1);
    }

    public static void main(String[] args) {
        System.out.println(count(14));
    }
}
