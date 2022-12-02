package tree.bst;

import tree.TreeNode;

/**
 * @source: leetcode98
 * @difficulty: medium
 * @topic: 验证二叉搜索树
 * @link: https://leetcode.cn/problems/validate-binary-search-tree/
 * @description: 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * @input: root = [2,1,3]
 * @output: true
 * @requirements:
 */
public class IsValidBST {
    public static void main(String[] args) {

    }
    private long pre = Long.MIN_VALUE;
    // 二叉搜索树「中序遍历」得到的值构成的序列一定是升序的
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean l = isValidBST(root.left);
        if(root.val <= pre) return false;
        pre = root.val;
        boolean r = isValidBST(root.right);
        return l && r;
    }
}
