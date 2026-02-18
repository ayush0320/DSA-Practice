public class BestTimeToBuyAndSellStocks {
    // Brute Force Approach
    // public static int maxProfit(int[] prices) {
    // int minPrice = Integer.MAX_VALUE;
    // int maxProfit = 0;
    // for (int i = 0; i < prices.length; i++) {
    // if (prices[i] < minPrice) {
    // minPrice = prices[i]; // found new minimum price
    // } else if (prices[i] - minPrice > maxProfit) {
    // maxProfit = prices[i] - minPrice; // found new maximum profit
    // }
    // }

    // return maxProfit;
    // }

    // Optimized Approach
    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                int currentProfit = prices[i] - buyPrice;
                profit = Math.max(currentProfit, profit);
            }
        }

        return profit;

    }

    public static void main(String[] args) {
        int[] prices = { 6, 1, 5, 3, 7, 4 };
        System.out.println(maxProfit(prices));
    }
}
