package twopointers;

import linkedList.ListNode;

/**
 * @source: leetcode142
 * @difficulty: medium
 * @topic: 环形链表II
 * @link: https://leetcode.cn/problems/linked-list-cycle-ii/
 * @description: 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * @input: head = [3,2,0,-4], pos = 1
 * @output: 返回索引为 1 的链表节点
 * @requirements:
 */
public class DetectCycle {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            // fast 走到链表末尾即可代表链表无环
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
