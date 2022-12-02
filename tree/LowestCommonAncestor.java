package tree;

import tree.traversal.InOrder;

import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @source: leetcode236
 * @difficulty: medium
 * @topic: 二叉树的最近公共祖先
 * @link: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * @description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * @output: 3
 * @requirements:
 */
public class LowestCommonAncestor {
    HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();

    public TreeNode lCAUnRec(TreeNode root, TreeNode p, TreeNode q) {
        fatherMap.put(root,root);
        rec(root);
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        TreeNode node = p;
        while (fatherMap.get(node) != node) {
            set.add(fatherMap.get(node));
            node = fatherMap.get(node);
        }
        node = q;
        while(!set.contains(node)) {
            node = fatherMap.get(node);
        }
        return node;
    }

    public void rec(TreeNode root) {
        if (root == null) {
            return;
        }
        fatherMap.put(root.left,root);
        fatherMap.put(root.right,root);
        rec(root.left);
        rec(root.right);
    }

    public TreeNode lCARec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lCARec(root.left, p, q);
        TreeNode right = lCARec(root.right, p, q);
        if (left != null && right != null) { // 左子树和右子树中都存在最近公共祖先
            return root;
        }
        return left != null ? left : right;
    }
}
