package linkedList.medium;

import linkedList.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @source: leetcode2
 * @difficulty: medium
 * @topic: 两数相加
 * @link: https://leetcode.cn/problems/add-two-numbers/
 * @description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * @input: l1 = [2,4,3], l2 = [5,6,4]
 * @output: [7,0,8]
 * @requirements:
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println();
    }

    // 官方答案
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode cur= newHead;
        int carry = 0;
        int sum;
        int l1Value;
        int l2Value;
        while (l1 != null || l2 != null) {
            l1Value = l1 == null ? 0 : l1.val;
            l2Value = l2 == null ? 0 : l2.val;
            sum = l1Value + l2Value + carry;

            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = node;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return newHead.next;
    }


}
