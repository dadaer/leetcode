package linkedList.easy;

import linkedList.ListNode;

/**
 * @source: leetcode206
 * @difficulty: easy
 * @topic: 反转链表
 * @link: https://leetcode.cn/problems/reverse-linked-list/
 * @description: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @input: head = [1,2,3,4,5]
 * @output: [5,4,3,2,1]
 * @requirements:
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static ListNode reverseListRec(ListNode head) {
        //最小子问题，结束
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
