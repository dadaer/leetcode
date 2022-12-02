package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode101
 * @difficulty: easy
 * @topic: 对称二叉树
 * @link: https://leetcode.cn/problems/symmetric-tree/
 * @description: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @input: root = [1,2,2,3,4,4,3]
 * @output: true
 * @requirements:
 */
public class IsSymmetric {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
