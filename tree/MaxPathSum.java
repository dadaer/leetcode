package tree;

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-1);
        System.out.println(maxPathSum(root));
    }

    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        getLongestPaths(root);
        return max;
    }

    public static int getLongestPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLongestPaths(root.left);
        int right = getLongestPaths(root.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        int pathLength = left + right + root.val;
        max = Math.max(pathLength, max);
        return Math.max(left, right) + root.val;
    }
}
