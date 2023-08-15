package ACM;

import java.util.Scanner;
import java.util.Stack;

public class LinkedListInput {
    //题目描述
    //对于一个链表 L: L0→L1→…→Ln-1→Ln,
    //将其翻转成 L0→Ln→L1→Ln-1→L2→Ln-2→…

    //先构建一个节点类，用于链表构建
    static class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //输入是一串数字，请将其转换成单链表格式之后，再进行操作
        //输入描述:
        //一串数字，用逗号分隔
        //输入
        //1,2,3,4,5
        Scanner scanner = new Scanner(System.in);
        //以字符串形式作为输入
        String str = scanner.nextLine();
        //通过分隔符将其转为字符串数组
        String[] arr = str.split(",");
        //初始化一个整数数组
        int[] ints = new int[arr.length];
        //给整数数组赋值
        for (int j = 0; j < ints.length; j++) {
            ints[j] = Integer.parseInt(arr[j]);
        }
        Stack<LinkNode> stack = new Stack<>();
        LinkNode head = new LinkNode(0);
        LinkNode p = head;
        //链表初始化并放入stack中
        for (int i = 0; i < ints.length; i++) {
            p.next = new LinkNode(ints[i]);
            p = p.next;
            stack.add(p);
        }
        head = head.next;
        //开始链表转换
        p = head;
        LinkNode q = stack.peek();
        while ((!p.equals(q)) && (!p.next.equals(q))) {
            q = stack.pop();
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            q = stack.peek();
        }
        q.next = null;
        //输出
        //1,5,2,4,3
        //打印
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.val);
            } else {
                System.out.print(head.val + ",");
            }
            head = head.next;
        }
    }
}

