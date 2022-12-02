package linkedList.easy;

import linkedList.ListNode;

/**
 * @source: leetcode21
 * @difficulty: easy
 * @topic: 合并两个有序链表
 * @link: https://leetcode.cn/problems/merge-two-sorted-lists/
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @input: l1 = [1,2,4], l2 = [1,3,4]
 * @output: [1,1,2,3,4,4]
 * @requirements:
 */
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead = new ListNode(0);
        ListNode head = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 == null) {
            head.next = list2;
        }
        if (list2 == null) {
            head.next = list1;
        }
        return newHead.next;
    }
}
