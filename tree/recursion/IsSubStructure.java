package tree.recursion;

import tree.TreeNode;

/**
 * @source: 剑指offer26
 * @difficulty: medium
 * @topic: 树的子结构
 * @link: https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
 * @description: 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * @input: A = [1,2,3], B = [3,1]
 * @output: false
 * @requirements:
 */
public class IsSubStructure {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        if (helper(A, B)){
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return helper(root1.left, root2.left) && helper(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
