package linkedList.easy;

import linkedList.ListNode;

/**
 * @source: leetcode234
 * @difficulty: easy
 * @topic: 回文链表
 * @link: https://leetcode.cn/problems/palindrome-linked-list/description/
 * @description: 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @input: head = [1,2,2,1]
 * @output: true
 * @requirements: 用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题 (medium)
 */
public class IsPalindrome {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 快指针走两步，慢指针走一步，快指针走到尾巴，则慢指针走了刚好一般
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 如果快指针不为null，则表示是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        // 反转链表
        ListNode after = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = after;
            after = slow;
            slow = temp;
        }
        fast = head;
        // 遍历正反链表，对比数据
        while (fast != null && after != null) {
            if (fast.val != after.val) {
                return false;
            }
            fast = fast.next;
            after = after.next;
        }
        return true;
    }
}
