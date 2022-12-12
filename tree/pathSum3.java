package tree;

/**
 * @source: leetcode437
 * @difficulty: medium
 * @topic: 路径总和 III
 * @link: https://leetcode.cn/problems/path-sum-iii/
 * @description: 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * @output: 3
 * @requirements:
 */
public class pathSum3 {
    public static void main(String[] args) {

    }

    private static int ans;
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return ans;
    }

    private static void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum == root.val) {
            ans++;
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
    }
}
