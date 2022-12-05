package tree.recursion;

import linkedList.ListNode;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {

    }

    private List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    private void dfs (TreeNode root, String s) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            s += root.val;
            ans.add(s);
            return;
        }
        dfs(root.left, s + root.val + "->");
        dfs(root.right, s + root.val + "->");
    }
}
