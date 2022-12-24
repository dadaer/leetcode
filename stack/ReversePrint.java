package stack;
import linkedList.ListNode;

import java.util.Stack;

/**
 * @source: 剑指offer06
 * @difficulty: easy
 * @topic: 从尾到头打印链表
 * @link: https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 * @input: head = [1,3,2]
 * @output: [2,3,1]
 * @requirements:
 */
public class ReversePrint {

    public static void main(String[] args) {

    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curNode = head;
        while(curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }
        int[] ans = new int[stack.size()];
        int index = 0;
        while (!stack.empty()){
            ListNode Node = stack.pop();
            ans[index++] = Node.val;
        }
        return ans;
    }
}
