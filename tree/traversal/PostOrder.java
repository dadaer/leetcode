package tree.traversal;

import tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @source: leetcode145
 * @difficulty: easy
 * @topic: 二叉树后序遍历
 * @link: https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @description: 给你二叉树的根节点 root ，返回它节点值的 后序 遍历。
 * @input: root = [1,null,2,3]
 * @output: [3,2,1]
 * @requirements:
 */
public class PostOrder {
    public static void main(String[] args) {

    }


    public static List<Integer> PostOrderUnRec(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        List<Integer> ret = new LinkedList<>();
        stack1.push(root);
        while (!stack1.empty()) {
            TreeNode node = stack1.pop();
            if (node == null) {
                continue;
            }
            ret.add(node.val);
            stack1.push(node.left);
            stack1.push(node.right);
        }
        Collections.reverse(ret);
        return ret;
    }
}
