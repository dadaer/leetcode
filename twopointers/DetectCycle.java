package twopointers;

import linkedList.ListNode;

/**
 * leetcode142 medium
 * 环形链表Ⅱ
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
