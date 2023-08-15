package hard;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @source: 剑指offer37
 * @difficulty: hard
 * @topic: 序列化二叉树
 * @link: https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/
 * @description: 请实现两个函数，分别用来序列化和反序列化二叉树。
 * @input: root = [1,2,3,null,null,4,5]
 * @output: root = [1,2,3,null,null,4,5]
 * @requirements:
 */
public class Codec {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,-1,-1,4,5,-1,-1,-1,-1,6,7};
        TreeNode root = TreeNode.createTree(ints, ints.length, 0);
        Codec ser = new Codec();
        Codec deser = new Codec();
        String ans = ser.serialize(root);
        System.out.println(ans);
        TreeNode ans1 = deser.deserialize(ans);
        System.out.println(ser.serialize(ans1));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder("[");
        queue.offer(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append("null,");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++; // 重要
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    // Decodes your encoded data to tree.
    // 递归方法有一些问题
    public static TreeNode deserialize1(String data) {
        if(data.equals("[]")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        return reDeserialize(vals, 0);
    }

    public static TreeNode reDeserialize(String[] data, int rootIndex) {
        if (data[rootIndex].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[rootIndex]));
        if (rootIndex * 2 + 1 < data.length) {
            root.left = reDeserialize(data, rootIndex * 2 + 1);
        }
        if (rootIndex * 2 + 1 < data.length ) {
            root.right = reDeserialize(data, rootIndex * 2 + 2);
        }
        return root;
    }
}
