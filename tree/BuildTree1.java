package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @source: leetcode106
 * @difficulty: medium
 * @topic: 从中序与后序遍历序列构造二叉树
 * @link: https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @description: 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * @input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * @output: [3,9,20,null,null,15,7]
 * @requirements:
 */
public class BuildTree1 {
    public static void main(String[] args) {

    }

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(inorder, postorder, 0, length - 1, 0, length - 1);
    }

    public TreeNode myBuildTree(int[] inorder, int[] postorder, int inorder_left,
                                int inorder_right, int postorder_left, int postorder_right) {
        if (postorder_left > postorder_right || inorder_left > inorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int rootIndex = postorder_right;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(postorder[rootIndex]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(postorder[rootIndex]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从左边界+1开始的 size_left_subtree」
        // 个元素就对应了中序遍历中「从左边界开始到根节点定位-1」的元素
        root.left = myBuildTree(inorder, postorder, inorder_left, inorder_root - 1,
                postorder_left, postorder_left + size_left_subtree - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目
        // 开始到 右边界」的元素就对应了中序遍历中「从根节点定位+1到右边界」的元素
        root.right = myBuildTree(inorder, postorder, inorder_root + 1, inorder_right,
                postorder_left + size_left_subtree, postorder_right - 1);
        return root;
    }
}
