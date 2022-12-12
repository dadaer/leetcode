package linkedList.medium;

import linkedList.ListNode;

/**
 * @source: leetcode82
 * @difficulty: medium
 * @topic: 删除排序链表中的重复元素 II
 * @link: https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * @description: 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * @input: head = [1,2,3,3,4,4,5]
 * @output: [1,2,5]
 * @requirements:
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        int[] ints = {1, 1};
        ListNode head = ListNode.createList(ints);
        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(200);
        dummyHead.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode cur = dummyHead;
        while (fast != null) {
            if (fast.val != slow.val) {
                cur = slow;
            } else {
                while (fast != null && fast.val == slow.val) {
                    fast = fast.next;
                }
                cur.next = fast;
            }
            slow = fast;
            if (fast != null) {
                fast = fast.next;
            } else {
                break;
            }
        }
        return dummyHead.next;
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val; // 使用变量保存
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
