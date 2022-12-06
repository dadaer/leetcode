package tree.recursion;

import linkedList.ListNode;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @source: leetcode257
 * @difficulty: easy
 * @topic: 二叉树的所有路径
 * @link: https://leetcode.cn/problems/binary-tree-paths/
 * @description: 给你一个二叉树的根节点 root ，按任意顺序 ，返回所有从根节点到叶子节点的路径。
 * @input: root = [1,2,3,null,5]
 * @output: ["1->2->5","1->3"]
 * @requirements:
 */
public class BinaryTreePaths {
    public static void main(String[] args) {

    }

    private List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    private void dfs (TreeNode root, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            s += root.val;
            ans.add(s);
            return;
        }
        dfs(root.left, s + root.val + "->");
        dfs(root.right, s + root.val + "->");
    }
}
