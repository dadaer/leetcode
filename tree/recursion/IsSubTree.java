package tree.recursion;

import tree.TreeNode;

/**
 * @source: leetcode572
 * @difficulty: easy
 * @topic: 另一棵树的子树
 * @link: https://leetcode.cn/problems/subtree-of-another-tree/
 * @description: 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * @input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * @output: true
 * @requirements:
 */
public class IsSubTree {
    public static void main(String[] args) {

    }

    public static boolean isSubtree0(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree0(root.left, subRoot) ||
                isSubtree0(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode s, TreeNode t) {
        // 同时为空 说明树一起到底，两树相同
        if (s == null && t == null) {
            return true;
        }
        // 如果上面没有返回值，说明必有一个没有为空（有可能两个都不为空）
        if (s == null || t == null) {
            return false;
        }
        // 如果判断到了这一步，说明两个都不为空
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
