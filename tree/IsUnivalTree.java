package tree;

/**
 * @source: leetcode965
 * @difficulty: easy
 * @topic: 单值二叉树
 * @link: https://leetcode.cn/problems/univalued-binary-tree/
 * @description: 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * @input: [1,1,1,1,1,null,1]
 * @output: true
 * @explanation
 * @requirements:
 */
public class IsUnivalTree {
    public static void main(String[] args) {

    }

    private int t = -1; // 结点的值范围为 [1, 99]

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (t == -1) {
            t = root.val; // 将 t 赋值为根的值
        }
        return (t == root.val) && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
