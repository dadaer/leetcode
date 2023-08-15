package hard;

import linkedList.ListNode;
import linkedList.easy.ReverseList;

/**
 * @source: leetcode25
 * @difficulty: hard
 * @topic: K 个一组翻转链表
 * @link: https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 * @description: 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * @input: head = [1,2,3,4,5], k = 2
 * @output: [2, 1, 4, 3, 5]
 * @requirements: 不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
 */
public class ReverseKGroup {
    public static void main(String[] args) {

    }

    // 递归写法
    public static ListNode reverseKGroupRec(ListNode head, int k) {
        ListNode p = head;
        // 寻找翻转链表的终点
        for (int i = 0; i < k; i++) {
            // 递归结束的条件,就是剩余的链表长度没有 k 那么长了
            if (p == null) return head; // 递归出口
            p = p.next;
        }
        // 翻转链表
        ListNode pre = null, cur = head;
        while (cur != p) { // 循环退出
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // 终点就是 head,让 head 连接后面的链表
        head.next = reverseKGroup(p, k);
        // 此时翻转链表后 pre 才是表头,返回链表表头即可
        return pre;
    }

    // 非递归
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = ReverseList.reverseList(start);
            start.next = next;
            pre = start;
            end = pre;
        }

        return dummy.next;
    }
}
