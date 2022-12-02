package dynamicprogramming.rob;

import tree.TreeNode;
import tree.recursion.MaxDepth;
import tree.traversal.LevelOrder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @source: leetcode337
 * @difficulty: medium
 * @topic: 打家劫舍III
 * @link: https://leetcode.cn/problems/house-robber-iii/
 * @description: 每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * @input: root = [3,2,3,null,3,null,1]
 * @output: 7
 * @requirements:
 */
public class Rob3 {
    public static void main(String[] args) {
        int[] tree = {3, 2, 3, -1, 3, -1, 1};
        TreeNode root = TreeNode.createTree(tree, tree.length, 0);
        System.out.println(rob(root));
    }
    public static int rob(TreeNode root) {
        int[] nums = levelOrder(root);
        return rob1(nums);
    }
    private static int rob1(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }
        // 状态定义：dp[i]表示前i天偷窃到的最高金额
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            // 状态转移
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
    private static int[] levelOrder(TreeNode root) {
        int depth = maxDepth(root);
        int[] ret = new int[depth];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        int size;
        int levelSum = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                levelSum += temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            level++;
            ret[depth - level] = levelSum;
            levelSum = 0;
        }
        return ret;
    }
    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
