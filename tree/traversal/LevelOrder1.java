package tree.traversal;

import tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指offer32-Ⅲ
 * medium
 * 从上到下打印二叉树
 */
public class LevelOrder1 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
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
