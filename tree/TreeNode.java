package tree;

// Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(int[] list, int length, int index) {
        if (index > length - 1 || list[index] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(list[index]);
        root.left = createTree(list, length, 2 * index + 1);
        root.right = createTree(list, length, 2 * index + 2);
        return root;
    }
}
