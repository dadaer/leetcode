public class ByteDance {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] lists = {1, 2, 3, 4, 5};
        ListNode head = createLinkedList(lists);
        ListNode cur = reverseKGroup(head, 3);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    private static ListNode createLinkedList(int[] lists) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int list : lists) {
            ListNode newNode = new ListNode(list);
            cur.next = newNode;
            cur = newNode;
        }
        return dummyHead.next;
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
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
}
