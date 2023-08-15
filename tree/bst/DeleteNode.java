package tree.bst;

import tree.TreeNode;

/**
 * @source: leetcode450
 * @difficulty: medium
 * @topic: 删除二叉搜索树中的节点
 * @link: https://leetcode.cn/problems/delete-node-in-a-bst/
 * @description: 给定一个二叉搜索树的根节点 root 和一个值 key，
 * 删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * @input: root = [5,3,6,2,4,null,7], key = 3
 * @output: [5,4,6,2,null,null,7]
 * @requirements:
 */
public class DeleteNode {
    public static void main(String[] args) {

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                successor.right = deleteNode(root.right, successor.val);
                successor.left = root.left;
                return successor;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            root.left = deleteNode(root.left, key);
            return root;
        }
    }


}
