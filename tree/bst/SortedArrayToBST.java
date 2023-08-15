package tree.bst;

import tree.TreeNode;

/**
 * @source: leetcode108
 * @difficulty: easy
 * @topic: 将有序数组转换为二叉搜索树
 * @link: https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
 * @description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @input: nums = [-10,-3,0,5,9]
 * @output: [0,-3,9,-10,null,5]
 * @explanation: [0,-10,5,null,-3,null,9]
 * @requirements:
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        return dfs(nums, 0, length - 1);
    }

    private static TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
