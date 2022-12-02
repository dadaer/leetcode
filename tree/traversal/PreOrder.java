package tree.traversal;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @source: leetcode144
 * @difficulty: easy
 * @topic: 二叉树前序遍历
 * @link: https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @description: 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * @input: root = [1,null,2,3]
 * @output: [1,2,3]
 * @requirements:
 */
public class PreOrder {
    public static void main(String[] args) {

    }

    public static List<Integer> PreOrderUnRec(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ret.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ret;
    }
}
