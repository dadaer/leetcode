package twopointers;

import linkedList.ListNode;

/**
 * @source: leetcode141
 * @difficulty: easy
 * @topic: 环形链表
 * @link: https://leetcode.cn/problems/linked-list-cycle/
 * @description: 给你一个链表的头节点 head ，判断链表中是否有环。
 * @input: head = [3,2,0,-4], pos = 1
 * @output: true
 * @requirements:
 */
public class HasCycle {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (fast == null || fast.next == null) {
            return false;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
