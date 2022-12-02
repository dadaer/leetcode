package linkedList;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createList(int[] list) {
        int length = list.length;
        ListNode header = new ListNode(list[0]);
        ListNode tail = header;
        for (int i = 1; i < length; i++) {
            ListNode node = new ListNode(list[i]);
            tail.next = node;
            tail = node;
        }
        return header;
    }
}
