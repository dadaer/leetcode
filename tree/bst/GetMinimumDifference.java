package tree.bst;

import tree.TreeNode;

import java.util.Map;

/**
 * @source: leetcode530
 * @difficulty: easy
 * @topic: 二叉搜索树的最小绝对差
 * @link: https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/
 * @description: 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * @input: root = [4,2,6,1,3]
 * @output: 1
 * @requirements:
 */
public class GetMinimumDifference {
    TreeNode pre;// 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        //左
        traversal(root.left);
        //中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        //右
        traversal(root.right);
    }
}
