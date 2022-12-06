package tree.traversal;

import tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @source: leetcode103
 * @difficulty: medium
 * @topic: 二叉树的锯齿形层序遍历
 * @link: https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/
 * @description: 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @input: root = [3,9,20,null,null,15,7]
 * @output: [[3],[20,9],[15,7]]
 * @requirements:
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevel = 1;
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            if (currentLevel % 2 == 0) {
                Collections.reverse(list);
            }
            currentLevel++;
            ret.add(list);
        }
        return ret;
    }
}
