package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode617
 * @difficulty: easy
 * @topic: 合并二叉树
 * @link: https://leetcode.cn/problems/merge-two-binary-trees/
 * @description: 两颗二叉树，如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * @input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * @output: [3,4,5,5,4,null,7]
 * @requirements:
 */
public class MergeTrees {

    public static void main(String[] args) {

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }
}
