package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode111
 * @difficulty: easy
 * @topic: 二叉树的最小深度
 * @link: https://leetcode.cn/problems/minimum-depth-of-binary-tree/description/
 * @description: 给定一个二叉树，找出其最小深度。
 * @input: root = [3,9,20,null,null,15,7]
 * @output: 2
 * @requirements:
 */
public class MinDepth {
    public static void main(String[] args) {

    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
