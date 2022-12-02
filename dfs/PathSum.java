package dfs;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指offer34
 * medium
 * 二叉树中和为某一值的路径
 */
public class PathSum {
    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    List<List<Integer>> ret = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, target, path);
        return ret;
    }

    public void dfs(TreeNode root, int target, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        if (target < 0) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<>(path));
            // 这里不能 return, return 后就无法执行 removelast()
            // 因为在判断之前 add 了元素
            // return;
        }
        dfs(root.left, target, path);
        dfs(root.right, target, path);
        path.removeLast();
    }
}
