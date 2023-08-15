package ACM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 题目描述
// 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
// 假设一个二叉搜索树具有如下特征：
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
// 例如：
// 输入：
//    5
//   / \
//  1   3
//     / \
//    4   6
// 输出: false

// 构造树需要的结点类


public class TreeInput {
    static class TreeNode {
        TreeNode left, right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        // 输入描述:
        // 第一行两个数n,root，分别表示二叉树有n个节点，第root个节点时二叉树的根
        // 接下来共n行，第i行三个数val_i,left_i,right_i，
        // 分别表示第i个节点的值val是val_i,左儿子left是第left_i个节点，右儿子right是第right_i个节点。
        // 节点0表示空。
        // 1<=n<=100000,保证是合法的二叉树
        // 输入
        // 5 1
        // 5 2 3
        // 1 0 0
        // 3 4 5
        // 4 0 0
        // 6 0 0
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int root = Integer.parseInt(s[1]);
        TreeNode[] tree = new TreeNode[n + 1];
        int[][] leaf = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            String[] ss = reader.readLine().split(" ");
            int val_i = Integer.parseInt(ss[0]);
            int left_i = Integer.parseInt(ss[1]);
            int right_i = Integer.parseInt(ss[2]);
            TreeNode node = new TreeNode(val_i);
            leaf[i][0] = left_i;
            leaf[i][1] = right_i;
            tree[i] = node;
        }
        for (int i = 1; i <= n; i++) {
            int left = leaf[i][0];
            if (left != 0) {
                tree[i].left = tree[left];
            } else {
                tree[i].left = null;
            }
            int right = leaf[i][1];
            if (right != 0) {
                tree[i].right = tree[right];
            } else {
                tree[i].right = null;
            }
        }
        TreeNode head = tree[root];
        boolean flag = isBinarySearchTree(head);
        System.out.println(flag);

    }

    private static boolean isBinarySearchTree(TreeNode node) {
        if (node == null) {
            return true;
        }
        int pre = Integer.MIN_VALUE;
        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty() || node != null) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            if (node == null) {
                break;
            }
            if (pre > node.val) {
                return false;
            }
            pre = node.val;
            node = node.right;
        }
        return true;
    }
}
