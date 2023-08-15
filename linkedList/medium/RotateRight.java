package linkedList.medium;

import linkedList.ListNode;

import java.util.List;

/**
 * @source: leetcode61
 * @difficulty: medium
 * @topic: 旋转链表
 * @link: https://leetcode.cn/problems/rotate-list/
 * @description: 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @input:  head = [1,2,3,4,5], k = 2
 * @output: [4,5,1,2,3]
 * @requirements:
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1, 2});
        System.out.println(rotateRight(head, 2));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (k % length == 0) {
            return head;
        }
        k %= length;
        temp = head;
        int i = 0;
        while (i < length - k - 1) {
            temp = temp.next;
            i++;
        }
        ListNode node = temp.next;
        temp.next = null;
        ListNode newHead = node;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head;
        return newHead;
    }
}
