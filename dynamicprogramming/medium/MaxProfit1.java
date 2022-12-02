package dynamicprogramming.medium;

/**
 * 剑指offer63
 * medium
 * 股票的最大利润
 */
public class MaxProfit1 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }


    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }
}
