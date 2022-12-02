package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @source: leetcode105
 * @difficulty: medium
 * @topic: 从前序与中序遍历序列构造二叉树
 * @link: https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @description: 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * @input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * @output: [3,9,20,null,null,15,7]
 * @requirements:
 */
public class BuildTree {
    public static void main(String[] args) {

    }

    private Map<Integer, Integer> indexMap;

    // 使用索引确定左右子树的先序和中序遍历序列数组
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left,
                                int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从左边界+1开始的 size_left_subtree」
        // 个元素就对应了中序遍历中「从左边界开始到根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1,
                preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目
        // 开始到 右边界」的元素就对应了中序遍历中「从根节点定位+1到右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1,
                preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
