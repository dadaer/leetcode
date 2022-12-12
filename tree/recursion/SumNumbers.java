package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode129
 * @difficulty: medium
 * @topic: 求根节点到叶节点数字之和
 * @link: https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 * @description: 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字,计算从根节点到叶节点生成的 所有数字之和 。
 * @input: root = [1,2,3]
 * @output: 25
 * @requirements:
 */
public class SumNumbers {
    public static void main(String[] args) {

    }

    private int ans;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += sum;
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
