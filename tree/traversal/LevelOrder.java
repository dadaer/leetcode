package tree.traversal;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @source: leetcode102
 * @difficulty: easy
 * @topic: 二叉树层序遍历
 * @link: https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @description: 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * @input: root = [3,9,20,null,null,15,7]
 * @output: [[3],[9,20],[15,7]]
 * @requirements:
 */
public class LevelOrder {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            ret.add(list);
        }
        return ret;
    }
}
