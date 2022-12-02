package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode543
 * @difficulty: easy
 * @topic: 二叉树的直径
 * @link: https://leetcode.cn/problems/diameter-of-binary-tree/
 * @description: 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * @input:
 * @output:
 * @requirements:
 */
public class DiameterOfBinaryTree {
    private int ans;
    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0; //每个节点并设一个全局变量 ans 记录 d_node 的最大值
        depth(root);
        // 最大直径等于最大路径的结点数量减 1
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        // 最大路径的结点数量
        // 左子树的深度 + 右子树的深度 + 根结点
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
