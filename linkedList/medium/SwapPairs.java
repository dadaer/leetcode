package linkedList.medium;

import linkedList.ListNode;

/**
 * @source: leetcode24
 * @difficulty: medium
 * @topic: 两两交换链表中的节点
 * @link: https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 * @description: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即只能进行节点交换）。
 * @input: head = [1, 2, 3, 4]
 * @output: [2, 1, 4, 3]
 * @requirements:
 */
public class SwapPairs {
    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }

}
