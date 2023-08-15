package hard;

import tree.TreeNode;

/**
 * @source: leetcode124
 * @difficulty: hard
 * @topic: 二叉树中的最大路径和
 * @link: https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * @description: 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * @input: root = [1,2,3]
 * @output: 6
 * @requirements:
 */
public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-1);
        System.out.println(maxPathSum(root));
    }

    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        getLongestPaths(root);
        return max;
    }

    public static int getLongestPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLongestPaths(root.left);
        int right = getLongestPaths(root.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        int pathLength = left + right + root.val;
        max = Math.max(pathLength, max);
        return Math.max(left, right) + root.val;
    }
}
