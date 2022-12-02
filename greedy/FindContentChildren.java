package greedy;

import java.util.Arrays;

/**
 * @source: leetcode455
 * @difficulty: easy
 * @topic: 分发饼干
 * @link: https://leetcode.cn/problems/assign-cookies/
 * @description:
 * @input: g = [1,2,3], s = [1,1]
 * @output: 1
 * @requirements:
 */
public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
