package tree.bst;

import tree.TreeNode;

/**
 * @source: 剑指offer68 - I
 * @difficulty: medium
 * @topic: 二叉搜索树的最近公共祖先
 * @link: https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * @output: 6
 * @explanation:
 * @requirements:
 */
public class BSTLCA {
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
