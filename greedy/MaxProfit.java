package greedy;

/**
 * @source: leetcode121
 * @difficulty: easy
 * @topic: 买卖股票的最佳时机
 * @link: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @description: 以数组
 * @input: [7,1,5,3,6,4]
 * @output: 5
 * @requirements:
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
