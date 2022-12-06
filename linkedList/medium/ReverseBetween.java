package linkedList.medium;

import linkedList.ListNode;
import tree.TreeNode;

/**
 * @source: leetcode92
 * @difficulty: medium
 * @topic: 反转链表 II
 * @link: https://leetcode.cn/problems/reverse-linked-list-ii/
 * @description: 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @input: head = [1,2,3,4,5], left = 2, right = 4
 * @output: [1,4,3,2,5]
 * @requirements:
 */
public class ReverseBetween {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode succ = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：反转链表的子区间
        reverse(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = succ;
        return dummyNode.next;
    }

    private static void reverse(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        reverse(head.next);
        head.next.next = head;
        head.next = null;
    }
}
