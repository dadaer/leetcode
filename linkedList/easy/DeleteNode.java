package linkedList.easy;

import linkedList.ListNode;

/**
 * @source: 剑指offer18
 * @difficulty: easy
 * @topic: 删除链表结点
 * @link: https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @description: 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 * @input: head = [4,5,1,9], val = 5
 * @output: [4,1,9]
 * @requirements:
 */
public class DeleteNode {
    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.val !=val)
            cur = cur.next;
        if (cur.next != null)
            cur.next = cur.next.next;
        return head;
    }

    public static ListNode deleteNode1(ListNode head, int val) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode cur = node;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return node.next;
    }
}
