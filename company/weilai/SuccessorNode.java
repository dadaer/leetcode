package company.weilai;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
    Node parent;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class SuccessorNode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rootIndex = scanner.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i <= n; i++) {
            int parentIndex = scanner.nextInt();
            int leftChildIndex = scanner.nextInt();
            int rightChildIndex = scanner.nextInt();
            if (leftChildIndex != 0) {
                nodes[parentIndex - 1].left = nodes[leftChildIndex - 1];
                nodes[leftChildIndex - 1].parent = nodes[parentIndex - 1];
            }
            if (rightChildIndex != 0) {
                nodes[parentIndex - 1].right = nodes[rightChildIndex - 1];
                nodes[rightChildIndex - 1].parent = nodes[parentIndex - 1];
            }
        }
        int targetIndex = scanner.nextInt();
        Node targetNode = nodes[targetIndex - 1];
        Node successor = inorderSuccess(targetNode);
        if (successor != null) {
            System.out.println(successor.val);
        } else {
            System.out.println(0);
        }
    }

    private static Node inorderSuccess(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (node.parent != null && node == node.parent.right) {
                node = node.parent;
            }
            return node.parent;
        }
    }



}
