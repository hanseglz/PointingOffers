package leetcode;

public class LC141 {
    /**
     * 141. Linked List Cycle
     *
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * There is a cycle in a linked list if there is some node in the list
     * that can be reached again by continuously following the next pointer.
     * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
     * Note that pos is not passed as a parameter.
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode (int val){
            this.val = val;
            this.next = null;
        }
        ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static boolean hasCycle(ListNode head) {
        /**
         * If there is only one pointer traversing the linked list,
         * you can NEVER know if there is a loop in the linked list,
         * and that's why you need more than one pointer and set their traversing speed differently.
         */
        if (head == null)
            return false;
        else if (head.next == null)
            return false;

        ListNode flag1 = head;
        ListNode flag2 = head;
        while (flag2 != null && flag2.next != null){    //Notice if f2.next is null then f2.next.next will throw an exception
            flag1 = flag1.next;
            flag2 = flag2.next.next;
            if (flag1 == flag2)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
