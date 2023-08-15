package tree.traversal;

import tree.TreeNode;

import java.util.*;

/**
 * @source: leetcode94
 * @difficulty: easy
 * @topic: 二叉树中序遍历
 * @link: https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * @description: 给你二叉树的根节点 root ，返回它节点值的 中序 遍历。
 * @input: root = [1,null,2,3]
 * @output: [1, 3, 2]
 * @requirements:
 */
public class InOrder {
    public static void main(String[] args) {

    }

    public static List<Integer> InOrderUnRec1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }


    public static List<Integer> InOrderUnRec(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ret.add(node.val);
            cur = node.right;
        }
        return ret;
    }
}
