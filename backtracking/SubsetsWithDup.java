package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode90
 * @difficulty: medium
 * @topic: 子集II
 * @link: https://leetcode.cn/problems/subsets-ii/
 * @description: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * @input: nums = [1,2,2]
 * @output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * @requirements:
 */
public class SubsetsWithDup {
    public static void main(String[] args) {

    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> subsetsWithDup( int[] nums ) {
        Arrays.sort( nums );
        subsetsWithDupHelper( nums, 0 );
        return res;
    }

    private static void subsetsWithDupHelper( int[] nums, int start ) {
        res.add( new ArrayList<>( path ) );

        for ( int i = start; i < nums.length; i++ ) {
            // 跳过当前树层使用过的、相同的元素
            if ( i > start && nums[i - 1] == nums[i] ) {
                continue;
            }
            path.add( nums[i] );
            subsetsWithDupHelper( nums, i + 1 );
            path.removeLast();
        }
    }
}
