package linkedList.easy;

import linkedList.ListNode;

/**
 * @source: leetcode160
 * @difficulty: easy
 * @topic: 相交链表
 * @link: https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * @description: 输入两个链表，找出它们的第一个公共节点。
 * @input: intersectVal = 8, listA = [4, 1, 8, 4, 5], listB = [5, 6, 1, 8, 4, 5], skipA = 2, skipB = 3
 * @output: Intersected at '8'
 * @requirements:
 */
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        int pre = 0;
        ListNode shorter;
        ListNode longer;
        if (lengthA > lengthB) {
            pre = lengthA - lengthB;
            shorter = headB;
            longer = headA;
        } else {
            pre = lengthB - lengthA;
            shorter = headA;
            longer = headB;
        }
        for (int i = 0; i < pre; i++) {
            longer = longer.next;
        }
        while (shorter != null) {
            if (shorter == longer) {
                return shorter;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        return null;
    }

    public static int getListLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
