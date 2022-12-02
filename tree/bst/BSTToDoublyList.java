package tree.bst;

import tree.TreeNode;

/**
 * @source: 剑指offer36
 * @difficulty: medium
 * @topic: 二叉搜索树与双向链表
 * @link: https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * @description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * @input:
 * @output:
 * @requirements:
 */
public class BSTToDoublyList {
    public static void main(String[] args) {

    }

    TreeNode pre, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void inorder(TreeNode cur) {
        if(cur == null) return;
        inorder(cur.left);
        // 第一个结点
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        inorder(cur.right);
    }
}
