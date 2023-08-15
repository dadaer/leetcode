package hard;

import linkedList.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @source: leetcode23
 * @difficulty: hard
 * @topic: 合并K个升序链表
 * @link: https://leetcode.cn/problems/merge-k-sorted-lists/description/
 * @description: 给你一个链表数组，每个链表都已经按升序排列
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @input: lists = [[1,4,5],[1,3,4],[2,6]]
 * @output: [1,1,2,3,4,4,5,6]
 * @requirements:
 */
public class MergeKLists {
    public static void main(String[] args) {

    }

    // 优先队列
    public static ListNode mergeKLists0(ListNode[] lists) {
        if (lists == null || lists.length == 0 ) {
            return null;
        }

//        PriorityQueue<ListNode> priQueue = new PriorityQueue<>((node1, node2) -> {
//            return node1.val - node2.val;
//        });

        PriorityQueue<ListNode> priQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val)); //定义优先级队列的排序方法（小顶堆）
        ListNode newHeadPre = new ListNode(-1);
        ListNode temp = newHeadPre;
        for (ListNode node : lists) {
            if (node != null) {
                priQueue.offer(node);
            }
        }
        while (!priQueue.isEmpty()) {
            ListNode node = priQueue.poll();
            if (node.next != null) priQueue.offer(node.next);
            temp.next = node;
            temp = temp.next;
        }
        return newHeadPre.next;
    }

    // 分治
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}
