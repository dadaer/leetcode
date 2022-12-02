package tree.bst;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @source: leetcode501
 * @difficulty: easy
 * @topic: 二叉搜索树的众数
 * @link: https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * @description: 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数
 * @input: root = [1,null,2,2]
 * @output: [2]
 * @requirements: 不用额外空间
 */
public class FindMode {
    private static ArrayList<Integer> resList;
    private static int maxCount;
    private static int count;
    private static TreeNode pre;

    public static void main(String[] args) {
        int[] tree = {1, -1, 2, -1, -1, 2}; // -1 表示空结点
        TreeNode root = TreeNode.createTree(tree, tree.length, 0);
        System.out.println(Arrays.toString(findMode(root)));
    }

    public static int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        findMode1(root);
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void findMode1(TreeNode root) {
        if (root == null) {
            return;
        }
        findMode1(root.left);

        int rootValue = root.val;
        // 计数
        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新结果以及maxCount
        if (count > maxCount) {
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(rootValue);
        }
        pre = root;

        findMode1(root.right);
    }
}
