package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @source: leetcode114
 * @difficulty: medium
 * @topic: 二叉树展开为链表
 * @link: https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * @description: 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * @input: root = [1,2,5,3,4,null,6]
 * @output: [1,null,2,null,3,null,4,null,5,null,6]
 * @requirements:
 */
public class Flatten {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        preOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    public void preOrder(TreeNode root, List<TreeNode> list){
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    //        1
    //       / \
    //      2   5
    //     / \   \
    //    3   4   6
    public void flatten1(TreeNode root) {
        if (root == null) return;
        // 递归左子树
        //                2
        //                 \
        //      2     ->    3
        //     / \           \
        //    3   4           4
        flatten(root.left);
        // 保存右子树
        //       5
        //        \
        //         6
        TreeNode right = root.right;
        //将 1 的左子树插入到右子树的地方
        //        1
        //         \
        //          2
        //           \
        //            3
        //             \
        //              4
        root.right = root.left;
        // 左子树置为null
        root.left = null;
        // 找到最右边结点
        while (root.right != null) {
            root = root.right;
        }
        // 递归右子树
        //     5   ->   5
        //      \        \
        //       6        6
        flatten(right);
        // 将原来的右子树接到最右边结点
        //       1
        //        \
        //         2
        //          \
        //           3
        //            \
        //             4
        //              \
        //               5
        //                \
        //                 6
        root.right = right;
    }
}
