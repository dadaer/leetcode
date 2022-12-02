package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode404
 * @difficulty: easy
 * @topic: 二叉树左叶子之和
 * @link: https://leetcode.cn/problems/sum-of-left-leaves/description/
 * @description: 给定二叉树的根节点 root ，返回所有左叶子之和。
 * @input: root = [3,9,20,null,null,15,7]
 * @output: 24
 * @requirements:
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        System.out.println();
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum = root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

}
