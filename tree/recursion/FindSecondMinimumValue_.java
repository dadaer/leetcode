package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode671
 * @difficulty: easy
 * @topic: 二叉树中第二小的节点
 * @link: https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/
 * @description: 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * @input: root = [2,2,5,null,null,5,7]
 * @output: 5
 * @requirements:
 */
public class FindSecondMinimumValue_ {
    public static void main(String[] args) {

    }

    public static int findSecondMinimumValue(TreeNode root) {
        // 根节点有 0 个结点，无第二小值
        if (root.left == null) {
            return -1;
        }
        int leftValue = root.left.val;
        int rightValue = root.right.val;
        // 等于 root.val 则是最小值，递归获取该子结点的第二小值
        // 不相等则是以该结点为根的子树的最小值，同时也是整棵树的第二小值
        if (leftValue == root.val) {
            leftValue = findSecondMinimumValue(root.left);
        }
        if (rightValue == root.val) {
            rightValue = findSecondMinimumValue(root.right);
        }
        // 为 -1 说明没有第二小值
        if (leftValue == -1) {
            return rightValue;
        }
        if (rightValue == -1) {
            return leftValue;
        }
        // 左右子节点都有第二小值，则取最小的值
        return Math.min(leftValue, rightValue);
    }
}
