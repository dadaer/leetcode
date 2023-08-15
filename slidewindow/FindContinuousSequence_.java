package slidewindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: 剑指offer57II
 * @difficulty: easy
 * @topic: 和为s的连续正数序列
 * @link: https://leetcode.cn/problems/two-sum/
 * @description: 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * @input: target = 9
 * @output: [[2,3,4],[4,5]]
 * @requirements:
 */
public class FindContinuousSequence_ {
    public static void main(String[] args) {
        System.out.println(findContinuousSequence(15));
    }


    // 滑动数组
    // 复习一下滑动数组的用法，可以降低时间复杂度,和第二种方法做对比
    public static int[][] findContinuousSequence0(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(s == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if(s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }

    public static List<List<Integer>> findContinuousSequence(int target) {
        List<List<Integer>> ret = new LinkedList<>();
        int j = target/2 + 1;
        int i = j - 1;
        int sum = 0;
        List<Integer> path;
        while (i > 0 && i < j) {
            for (int k = i; k <= j ; k++) {
                sum += k;
            }
            if (sum == target) {
                path = new LinkedList<>();
                for (int k = i; k <= j ; k++) {
                    path.add(k);
                }
                ret.add(path);
                i--;
                j--;
            } else if (sum < target) {
                i--;
            } else {
                j--;
            }
            sum = 0;
        }
        return ret;
    }
}
