package tree.traversal;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @source: leetcode513
 * @difficulty: medium
 * @topic: 找树左下角的值
 * @link: https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @description: 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * @input: [1,2,3,4,null,5,6,null,null,7]
 * @output: 7
 * @requirements:
 */
public class FindBottomLeftValue {
    public static void main(String[] args) {

    }

    public static int findBottomLeftValue(TreeNode root) {
        int depth = maxDepth(root);
        int currentDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            currentDepth++;
            if (currentDepth == depth) {
                return queue.peek().val;
            }
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return 0;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
