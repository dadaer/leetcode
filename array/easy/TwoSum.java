package array.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode1
 * @difficulty: easy
 * @topic: 两数之和
 * @link: https://leetcode.cn/problems/two-sum/
 * @description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * @input: nums = [2,7,11,15], target = 9
 * @output: [0,1]
 * @requirements:
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum1(new int[]{2,7,11,15},9));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            } else {
                map.put(target - nums[i],i);
            }
        }
        return null;
    }

    public static List<Integer> twoSum1(int[] nums, int target) {
        List<Integer> list = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                list.add(map.get(num));
                list.add(num);
                return list;
            } else {
                map.put(target - num, num);
            }
        }
        return null;
    }
}
