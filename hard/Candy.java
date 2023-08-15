package hard;

/**
 * @source: leetcode135
 * @difficulty: hard
 * @topic: 分发糖果
 * @link: https://leetcode.cn/problems/candy/description/
 * @description: n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * @input: ratings = [1,0,2]
 * @output: 5
 * @requirements: 你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 */
public class Candy {
    public static void main(String[] args) {
        candy(new int[]{2, 0, 3, 1});
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    public static int candy2(int[] ratings) {
        int n = ratings.length;
        int[] diffToRight = new int[n], diffToLeft = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                diffToRight[i] = diffToRight[i - 1] + 1;
            }

            if (ratings[n - 1 - i] > ratings[n - i]) {
                diffToLeft[n - 1 - i] = diffToLeft[n - i] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            ans += Math.max(diffToRight[i], diffToLeft[i]);
        }
        return ans + n;
    }
}

