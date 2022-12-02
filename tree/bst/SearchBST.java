package tree.bst;

import tree.TreeNode;

/**
 * @source: leetcode700
 * @difficulty: easy
 * @topic: 二叉搜索树中的搜索
 * @link: https://leetcode.cn/problems/search-in-a-binary-search-tree/
 * @description: 在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * @input: root = [4,2,7,1,3], val = 2
 * @output: [2,1,3]
 * @requirements:
 */
public class SearchBST {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
