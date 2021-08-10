package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LC234 {
    /**
     * 234. Palindrome(回文) Linked List
     *
     * Given the head of a singly linked list, return true if it is a palindrome.
     *
     * Input: head = [1,2,2,1]
     * Output: true
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next ){
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null){
            arrayList.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < arrayList.size() / 2; i++){
            if (arrayList.get(i) != arrayList.get(arrayList.size()-i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);
        System.out.println(isPalindrome(l1));
    }
}
