package linkedList.medium;

import linkedList.ListNode;

/**
 * @source: leetcode143
 * @difficulty: medium
 * @topic: 重排链表
 * @link: https://leetcode.cn/problems/reorder-list/description/
 * @description:
 * @input: head = [1, 2, 3, 4, 5]
 * @output: [1, 5, 2, 4, 3]
 * @requirements:
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode list1 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        reorderList(list1);
        ListNode node = list1;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode middle = searchMiddleNode(head);
        ListNode headB = middle.next;
        middle.next = null;
        headB = reverseList(headB);
        merge(head, headB);
    }

    public static ListNode searchMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        //最小子问题，结束
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void merge(ListNode headA, ListNode headB) {
        ListNode tempA;
        ListNode tempB;
        while (headA != null && headB != null) {
            tempA = headA.next;
            tempB = headB.next;
            headA.next = headB;
            headA = tempA;
            headB.next = headA;
            headB = tempB;
        }
    }
}
