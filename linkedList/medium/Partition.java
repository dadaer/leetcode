package linkedList.medium;

import linkedList.ListNode;

/**
 * @source: leetcode86
 * @difficulty: medium
 * @topic: 分割链表
 * @link: https://leetcode.cn/problems/partition-list/description/
 * @description: 给你一个链表的头节点 head 和一个特定值 x ，
 * 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * @input: head = [1,4,3,2,5,2], x = 3
 * @output: [1,2,2,4,3,5]
 * @requirements:
 */
public class Partition {
    public static void main(String[] args) {
        System.out.println(partition(null, 0));
    }

    // 快排方法
    public static ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(-200, head);
        ListNode insertPosition = dummyHead;
        while (insertPosition.next!= null && insertPosition.next.val < x) {
            insertPosition = insertPosition.next;
        }
        ListNode pre = insertPosition;
        ListNode node = insertPosition.next;
        while (node != null) {
            if (node.val < x) {
                pre.next = node.next;
                node.next = insertPosition.next;
                insertPosition.next = node;
                insertPosition = insertPosition.next;
                node = pre.next;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode partition1(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode larger = new ListNode(-1);
        ListNode smallerHead = smaller;
        ListNode largerHead = larger;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            if (cur.val < x) {
                smaller.next = cur;
                smaller = smaller.next;
            }
            if (cur.val >= x) {
                larger.next = cur;
                larger = larger.next;
            }
            cur.next = null;
            cur = temp;
        }
        smaller.next = new ListNode(x);
        smaller.next.next = largerHead.next;
        return smallerHead.next;
    }
}
