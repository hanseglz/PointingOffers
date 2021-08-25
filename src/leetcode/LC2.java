package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LC2 {
    /**
     * 2. Add Two Numbers
     *
     * You are given two non-isEmpty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * The mathematical way, the stupid way, the frustrated way, the ONLY way.
         */
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        while (l1 != null){
            queue1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            queue2.add(l2.val);
            l2 = l2.next;
        }

        boolean additional = false;
        ListNode preHead = new ListNode(-1);
        ListNode head = preHead;
        while (!queue1.isEmpty() && !queue2.isEmpty()){
            ListNode listNode = new ListNode(queue1.poll() + queue2.poll());
            if (additional){
                listNode.val += 1;
                additional = false;
            }
            if (listNode.val >= 10){
                listNode.val -= 10;
                additional = true;
            }
            head.next = listNode;
            head = head.next;
        }
        if (queue1.isEmpty() && queue2.isEmpty() && !additional){
            head.next = new ListNode(1);
            return preHead.next;
        }

        queue1 = queue1.isEmpty() ? queue2 : queue1;
        while (!queue1.isEmpty()){
            ListNode listNode = new ListNode(queue1.poll());
            if (additional){
                listNode.val += 1;
                additional = false;
            }
            if (listNode.val >= 10){
                listNode.val -= 10;
                additional = true;
            }
            head.next = listNode;
            head = head.next;
        }
        if (!additional){
            head.next = new ListNode(1);
        }

        return preHead.next;
    }

}
