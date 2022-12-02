package linkedList.easy;

import linkedList.ListNode;

/**
 * @source: leetcode203
 * @difficulty: easy
 * @topic: 移除链表元素
 * @link: https://leetcode.cn/problems/remove-linked-list-elements/
 * @description: 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @input: head = [1, 2, 6, 3, 4, 5, 6], val = 6
 * @output: [1, 2, 3, 4, 5]
 * @requirements:
 */
public class RemoveElements {
    public static void main(String[] args) {

    }

    // 递归
    public static ListNode removeElementsRec(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElementsRec(head.next, val);
        return head.val == val ? head.next : head;
    }

    // 迭代
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head; // 哑结点用来处理头结点
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}
