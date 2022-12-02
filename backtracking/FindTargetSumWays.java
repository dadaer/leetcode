package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode494
 * medium
 * 目标和
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}, 1));
    }

    private static List<List<Character>> ret = new LinkedList<>();
    private static int sum = 0;

    public static int findTargetSumWays(int[] nums, int target) {
        char[] chars = new char[]{'+', '-'};
        int length = nums.length;
        List<Character> path = new ArrayList<>();
        backtracking(nums, target, chars, length, path);
        return ret.size();
    }

    private static void backtracking(int[] nums, int target, char[] chars, int length, List<Character> path) {
        if(path.size() == length){
            for (int i = 0; i < nums.length; i++) {
                if (path.get(i) == '+') {
                    sum += nums[i];
                } else {
                    sum -= nums[i];
                }
            }
            if (sum == target) {
                ret.add(new LinkedList<>(path));
            }
            sum = 0;
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            path.add(chars[i]);
            backtracking(nums, target, chars, length, path);
            path.remove(path.size() - 1);
        }
    }

    int count = 0;

    public int findTargetSumWays1(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }


}
