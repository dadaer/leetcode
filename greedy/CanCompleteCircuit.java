package greedy;

/**
 * @source: leetcode134
 * @difficulty: medium
 * @topic: 加油站
 * @link: https://leetcode.cn/problems/gas-station/description/
 * @description: 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，
 * 否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * @input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * @output: 3
 * @requirements:
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }

    // 贪心
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++)
        {
            curSum += gas[i] - cost[i]; // 当前区间剩余的油量
            totalSum += gas[i] - cost[i]; // 总剩余油量
            if(curSum < 0)
            {
                start = i + 1;
                curSum = 0;
            }
        }
        if(totalSum < 0) { // 总剩余油量为负数，肯定不可能绕一圈。
            return -1;
        }
        return start;
    }

    // 暴力
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int length = gas.length;
        int oilCapacity;
        for (int i = 0; i < length; i++) {
            if (gas[i] == 0) { // 剪枝
                continue;
            }
            if (gas[i] >= cost[i]) {
                oilCapacity = gas[i] - cost[i];
                for (int j = i + 1; j < length + i; j++) {
                    oilCapacity += gas[j % length] - cost[j % length];
                    if (oilCapacity < 0) {
                        break;
                    }
                }
                if (oilCapacity >= 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
