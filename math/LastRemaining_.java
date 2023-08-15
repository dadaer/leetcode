package math;

import java.util.ArrayList;

/**
 * @source: 剑指offer62
 * @difficulty: easy
 * @topic: 圆圈中最后剩下的数字
 * @link: https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @description: 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * @input: n = 5, m = 3
 * @output: 3
 * @explanation: 0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3
 * @requirements:
 */
public class LastRemaining_ {
    public static void main(String[] args) {
        System.out.println(lastRemaining1(70866, 116922));
    }

    // 官解 约瑟夫环问题
    public static int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; ++i) {
            f = (m + f) % i;
        }
        return f;
    }

    // 官解 模拟
    public static int lastRemaining0(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    // 自己写的超时了
    public static int lastRemaining1(int n, int m) {
        boolean[] booleans = new boolean[n];
        int index = 0;
        int count = m;
        for (int i = 0; i < n - 1; i++) {
            while (count >= 1) {
                if (!booleans[index]) {
                    count--;
                }
                index++;
                if (index == n && count != 0) {
                    index = 0;
                }
            }
            booleans[--index] = true;
            count = m;
        }
        for (int i = 0; i < n; i++) {
            if (!booleans[i]) {
                return i;
            }
        }
        return 0;
    }


}
