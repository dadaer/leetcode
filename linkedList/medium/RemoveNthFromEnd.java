package linkedList.medium;

import linkedList.ListNode;

/**
 * @source: leetcode19
 * @difficulty: medium
 * @topic: 删除链表的倒数第 N 个结点
 * @link: https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @input: head = [1, 2, 3, 4, 5], n = 2
 * @output: [1, 2, 3, 5]
 * @requirements: 使用一趟扫描实现
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    // 双指针只遍历一次
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
