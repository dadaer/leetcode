package greedy;


/**
 * @source: leetcode122
 * @difficulty: medium
 * @topic: 买卖股票的最佳时机 II
 * @link: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * @description:
 * @input: prices = [7,1,5,3,6,4]
 * @output: 7
 * @requirements:
 */
public class MaxProfit2 {
    public static void main(String[] args) {
        System.out.println(maxProfit1(new int[]{6,1,3,2,4,7}));
    }

    public static int maxProfit1(int[] prices) {
        int profit = 0;
        int boughtIndex = 0;
        for(int i = 0; i < prices.length; i++) {
            if (i < prices.length - 1) {
                if (prices[i + 1] < prices[i]) {
                    profit += prices[i] - prices[boughtIndex];
                    boughtIndex = i + 1;
                }
            } else {
                profit += prices[i] - prices[boughtIndex];
            }
        }
        return profit;
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
