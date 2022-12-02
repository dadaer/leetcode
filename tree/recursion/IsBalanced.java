package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode110
 * @difficulty: easy
 * @topic: 平衡二叉树
 * @link: https://leetcode.cn/problems/balanced-binary-tree/
 * @description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * @input: root = [3,9,20,null,null,15,7]
 * @output: true
 * @requirements:
 */
public class IsBalanced {
    public static void main(String[] args) {

    }
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftTreeHeight = depth(root.left);
        int rightTreeHeight = depth(root.left);
        return Math.abs(leftTreeHeight - rightTreeHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
