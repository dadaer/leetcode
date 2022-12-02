package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @source: leetcode513
 * @difficulty: medium
 * @topic: 找树左下角的值
 * @link: https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @description: 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * @input: root = [2,1,3]
 * @output: 1
 * @requirements:
 */
public class FindBottomLeftValue {
    public static void main(String[] args) {

    }

    // 层次遍历最后一层
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = maxDepth(root);
        queue.add(root);
        int curDepth = 1;
        while (!queue.isEmpty()) {
            if (curDepth == depth) {
                return queue.poll().val;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            curDepth++;
        }
        return 0;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
