package tree.bst;

import tree.TreeNode;

/**
 * @source: leetcode230
 * @difficulty: medium
 * @topic: 二叉搜索树中第 K 小的元素
 * @link: https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 * @description: 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @input: root = [3,1,4,null,2], k = 1
 * @output: 1
 * @requirements:
 */
public class KthSmallest {
    public static void main(String[] args) {

    }

    private int count;
    private int ans;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        inOrder(root.right, k);
    }
}
