package tree;

import linkedList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode113
 * @difficulty: medium
 * @topic: 路径总和 II
 * @link: https://leetcode.cn/problems/path-sum-ii/
 * @description: 给你二叉树的根节点 root 和一个整数目标和 targetSum，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * @input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * @output: [[5,4,11,2],[5,8,4,5]]
 * @requirements:
 */
public class PathSum {
    public static void main(String[] args) {
        int[] ints = {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, 5, 1};
        TreeNode head = TreeNode.createTree(ints, ints.length, 0);
        System.out.println(pathSum(head, 22));
    }

    private static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(root, targetSum, list);
        return ans;
    }

    private static void dfs(TreeNode root, int targetSum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            ans.add(new LinkedList<>(list));
//            return; // 这里不能提前 return
        }
        dfs(root.left, targetSum - root.val, list);
        dfs(root.right, targetSum - root.val, list);
        list.removeLast();
    }
}
