package linkedList.medium;

import linkedList.ListNode;

/**
 * @source: leetcode148
 * @difficulty: medium
 * @topic: 排序链表
 * @link: https://leetcode.cn/problems/sort-list/
 * @description: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * @input: head = [4,2,1,3]
 * @output: [1, 2, 3, 4]
 * @requirements: 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 */
public class SortList {
    public static void main(String[] args) {
        int[] ints = {4, 2, 1, 3};
        System.out.println(sortList1(ListNode.createList(ints)));
    }

    // 归并 自顶向下
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = searchMiddleNode(head);
        ListNode temp = middle.next;
        middle.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(temp);
        return merge(head1, head2);
    }

    public static ListNode searchMiddleNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 归并 自底向上
    public static ListNode sortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        // 1. 首先从头向后遍历,统计链表长度
        int length = 0; // 用于统计链表长度
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        // 2. 初始化 引入 dummynode
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev;
        ListNode curr;
        ListNode head_1;
        ListNode head_2;
        ListNode next;
        // 3. 每次将链表拆分成若干个长度为 subLen 的子链表 , 并按照每两个子链表一组进行合并
        for (int subLen = 1; subLen < length; subLen <<= 1) { // subLen 每次左移一位（即 sublen = sublen * 2） PS:位运算对 CPU 来说效率更高
            prev = dummyHead;
            curr = dummyHead.next;     // curr 用于记录拆分链表的位置
            while (curr != null) {               // 如果链表没有被拆完
                // 3.1 拆分subLen长度的链表1
                head_1 = curr;        // 第一个链表的头 即 curr 初始的位置
                for (int i = 1; i < subLen && curr.next != null; i++) {     // 拆分出长度为 subLen 的链表 1
                    curr = curr.next;
                }
                // 3.2 拆分 subLen 长度的链表 2
                head_2 = curr.next;  // 第二个链表的头  即 链表 1 尾部的下一个位置
                curr.next = null;             // 断开第一个链表和第二个链表的链接
                curr = head_2;                // 第二个链表头 重新赋值给 curr
                for (int i = 1; i < subLen && curr != null; i++) {      // 再拆分出长度为 subLen 的链表 2
                    curr = curr.next;
                }
                // 3.3 再次断开 第二个链表最后的 next 的链接
                next = null;
                if (curr != null) {
                    next = curr.next;   // next 用于记录 拆分完两个链表的结束位置
                    curr.next = null;   // 断开连接
                }
                // 3.4 合并两个 subLen 长度的有序链表
                prev.next = merge(head_1, head_2);        // prev.next 指向排好序链表的头
                while (prev.next != null) {  // while 循环 将 prev 移动到 subLen * 2 的位置后去
                    prev = prev.next;
                }
                curr = next;              // next 用于记录 拆分完两个链表的结束位置
            }
        }
        // 返回新排好序的链表
        return dummyHead.next;
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
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
