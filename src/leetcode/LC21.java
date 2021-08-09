package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC21 {
    /**
     * 21. Merge Two Sorted Lists
     *
     * Merge two sorted linked lists and return it as a sorted list.
     * The list should be made by splicing together the nodes of the first two lists.
     *
     * Input: l1 = [1,2,4], l2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){ this.val = val; }
        ListNode(int val, ListNode next){ this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode prehead = new ListNode(-1);
        ListNode root = prehead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                root.next = new ListNode(l1.val);
                root = root.next;
                l1 = l1.next;
            } else {
                root.next = new ListNode(l2.val);
                root = root.next;
                l2 = l2.next;
            }
        }

        root.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1,new ListNode(2, new ListNode(4)));
        ListNode root2 = new ListNode(1,new ListNode(3, new ListNode(4)));
        ListNode root = mergeTwoLists(root1, root2);
        while (root != null){
            System.out.println(root.val);
            root = root.next;
        }
    }
}
