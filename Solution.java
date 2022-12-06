import design.LRUCache;
import linkedList.ListNode;
import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    private Map<Integer, DListNode> map = new HashMap<>();
    private int capacity;
    private int size;

    private DListNode head, tail;

    class DListNode {
        int key;
        int value;
        DListNode pre;
        DListNode next;
        public DListNode() {}

        public DListNode(int _key, int _value) {
            this.key = _key;
            this.value = _value;
        }
    }

    public Solution(int capacity) {
        this.capacity = capacity;
        this.head = new DListNode();
        this.tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DListNode node = map.get(key);
        if (node == null) {
            DListNode newNode = new DListNode(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                DListNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DListNode newNode) {
        newNode.next = head.next;
        newNode.pre = head;
        head.next.pre = newNode;
        head.next = newNode;
    }

    private void removeNode(DListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DListNode removeTail() {
        DListNode res = tail.pre;
        removeNode(res);
        return res;
    }
}
