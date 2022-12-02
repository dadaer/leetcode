package array.easy;

import java.util.Arrays;

/**
 * @source: 剑指offer61
 * @difficulty: easy
 * @topic: 扑克牌中的顺子
 * @link: https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * @description: 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * @input: [1,2,3,4,5]
 * @output: True
 * @requirements:
 */
public class IsStraight {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{0, 0 , 1, 2, 5}));
    }

    public static boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
