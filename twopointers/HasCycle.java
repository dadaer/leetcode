package twopointers;

import linkedList.ListNode;

/*
    给你一个链表的头节点 head ，判断链表中是否有环。
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
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
