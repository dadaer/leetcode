package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode226
 * @difficulty: easy
 * @topic: 翻转二叉树
 * @link: https://leetcode.cn/problems/invert-binary-tree/
 * @description: 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @input: root = [4,2,7,1,3,6,9]
 * @output: [4,7,2,9,6,3,1]
 * @requirements:
 */
public class InvertTree {
    public static void main(String[] args) {

    }

    // 先从叶子结点开始翻转，如果当前遍历到的节点 root 的左右两棵子树都已经翻转，
    // 那么我们只需要交换两棵子树的位置，即可完成以 root 为根节点的整棵子树的翻转
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 需要将子树的翻转的结果保存到变量中
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
