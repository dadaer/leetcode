package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @source: leetcode662
 * @difficulty: medium
 * @topic: 二叉树最大宽度
 * @link: https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
 * @description: 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
 * 将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * @input: root = [1,3,2,5,3,null,9]
 * @output: 4
 * @explanation 最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9)
 * @requirements:
 */
public class WidthOfBinaryTree {
    public static void main(String[] args) {

    }

    // 把结点的 val 改成下标
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        root.val = 0;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            ans = Math.max(ans, deque.peekLast().val - deque.peekFirst().val);
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.removeFirst();
                if (cur.left != null) {
                    cur.left.val = cur.val * 2 + 1;
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2 + 2;
                    deque.addLast(cur.right);
                }
            }
        }
        return ans + 1;
    }
}
