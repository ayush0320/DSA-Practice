package stacks.medium;
// LC. 901 Online Stock Span
// https://leetcode.com/problems/online-stock-span/description/
// https://youtu.be/01vBuZyMfqk

// Pattern:
// → monotonic stack (decreasing stack)
// → instead of storing values in the stack,
//  we store pairs of (price, span) to keep track of the span for each price

// ------------------------------------------------------------------------

import java.util.Stack;

// → Since this is a stateful problem, we need to maintain the state of the
// previous prices and their spans
// → We create a class because we need memory to store the span for each price

class StockSpanner {
    Stack<int[]> stack; // stack variable to store pairs of (price, span)

    // Constructor to initialize the stack
    public StockSpanner() {
        stack = new Stack<>();
    }

    // Method to process the next price and return its span
    public int next(int price) {
        int span = 1; // Minimum span is 1 (the current price itself)

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // Add the span of the popped price
        }

        stack.push(new int[] { price, span }); // Push the current price and its span
        return span;

    }
}

public class OnlineStockSpan {

    // ==================

    // Brute Force Approach
    // → For each price, we can look back at the previous prices and count how many
    // consecutive prices are less than or equal to the current price.
    // → Time Complexity: O(n^2) - TLE
    // → Space Complexity: O(n) - for the stack

    // ==================

    // Optimal Approach: Monotonic Stack
    // 1. We use a stack to keep track of the previous prices and their spans.
    // 2. For each new price, we pop from the stack until we find a price greater
    // than the current price.
    // 3. The span for the current price is the sum of the spans of the popped
    // prices plus one (for the current price itself).
    // 4. We then push the current price and its span onto the stack.

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements smaller than current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack empty, all previous prices are smaller
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Span is current index minus index of higher price
                span[i] = i - stack.peek();
            }

            // Push current day index
            stack.push(i);
        }
        return span;
    }

    // ==================

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // returns 1
        System.out.println(stockSpanner.next(80)); // returns 1
        System.out.println(stockSpanner.next(60)); // returns 1
        System.out.println(stockSpanner.next(70)); // returns 2
        System.out.println(stockSpanner.next(60)); // returns 1
        System.out.println(stockSpanner.next(75)); // returns 4
        System.out.println(stockSpanner.next(85)); // returns 6
    }

}
