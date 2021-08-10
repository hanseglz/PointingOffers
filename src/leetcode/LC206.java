package leetcode;

import java.util.Stack;

public class LC206 {
    /**
     * 206. Reverse Linked List
     * The same as Test24
     *
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }

        ListNode preHead = new ListNode();
        ListNode flag = preHead;
        while (!stack.empty()){
            ListNode node = new ListNode(stack.pop());
            flag.next = node;
            flag = flag.next;
        }

        return preHead.next;
    }
}
