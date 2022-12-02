package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer35
 * medium
 * 复杂链表的复制
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {

    // 1、拼接 + 拆分
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 1、复制新结点
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        // 2、修改指针指向
        cur = head;
        while (cur != null) {
            // cur.random可能问null
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 3、拆分
        Node pre = head, res = head.next;
        cur = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        // 最后一个原籍诶单指向空，否则会链接上
        pre.next = null;
        return res;
    }

    // 2、哈希表方法
    public Node copyRandomList1(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            // 复制的新链表的每个结点的指针指向的是新的复制的结点
            // value -> value, 不能指向 key
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }
}


