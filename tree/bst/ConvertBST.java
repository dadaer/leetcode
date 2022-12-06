package tree.bst;

import tree.TreeNode;

/**
 * @source: leetcode538
 * @difficulty: medium
 * @topic: 把二叉搜索树转换为累加树
 * @link: https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * @description: 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * @input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * @output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * @requirements:
 */
public class ConvertBST {
    public static void main(String[] args) {

    }

    int sum = 0;//当前累加和
    public TreeNode convertBST(TreeNode root){
        // 从右开始的中序遍历
        if(root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    private int lastSum;

    public TreeNode convertBST1(TreeNode root) {
        recursion(root);
        return root;
    }

    private void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST(root.right);
        root.val += lastSum;
        lastSum = root.val;
        convertBST(root.left);
    }
}
