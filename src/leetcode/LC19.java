package leetcode;

public class LC19 {
    /**
     * 19. Remove Nth Node From End of List
     *
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     *
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        ListNode preHead = head;
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        if (len == n)
            return preHead.next;

        int target = len - n;
        head = preHead;
        while (target > 1){
            head = head.next;
            target--;
        }
        head.next = head.next.next;

        return preHead;
    }
}
