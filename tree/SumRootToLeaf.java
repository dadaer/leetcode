package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @source: leetcode1022
 * @difficulty: easy
 * @topic: 从根到叶的二进制数之和
 * @link: https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 * @description: 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字
 * @input: root = [1,0,1,0,1,0,1]
 * @output: 22
 * @explanation (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * @requirements:
 */
public class SumRootToLeaf {
    public static void main(String[] args) {

    }

    // 方法1
    private int ans;

    public int sumRootToLeaf(TreeNode root) {
        findSum(0, root);
        return ans;
    }

    public void findSum(int sum, TreeNode t) {
        if (t.left == null && t.right == null) {
            ans += sum * 2 + t.val;
        } else {
            if (t.left != null) {
                findSum(2 * sum + t.val, t.left);
            }
            if (t.right != null) {
                findSum(2 * sum + t.val, t.right);
            }
        }
    }

    //方法2
    private List<String> list = new ArrayList<>();

    public int sumRootToLeaf1(TreeNode root) {
        if (root == null) return 0;
        dfs(root, "");
        int ans = 0;
        for (String s : list) {
            ans += cal(s);
        }
        return ans;
    }

    //收集所有的路径
    public void dfs(TreeNode root, String path) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(new String(path + root.val));
            return;
        }
        dfs(root.left, path + root.val);
        dfs(root.right, path + root.val);
    }

    //计算路径对应的十进制
    public int cal(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            res += (s.charAt(i) - '0') * Math.pow(2, len - i - 1);
        }
        return res;
    }

}
