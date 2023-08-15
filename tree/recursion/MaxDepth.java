package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode104
 * @difficulty: easy
 * @topic: 二叉树的最大深度
 * @link: https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 * @description: 给定一个二叉树，找出其最大深度。
 * @input: [3,9,20,null,null,15,7]
 * @output: 3
 * @requirements:
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
