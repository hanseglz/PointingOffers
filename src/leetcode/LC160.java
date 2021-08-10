package leetcode;

public class LC160 {
    /**
     * 160. Intersection of Two Linked Lists
     *
     * Given the heads of two singly linked-lists headA and headB,
     * return the node at which the two lists intersect.
     * If the two linked lists have no intersection at all, return null.
     * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
     * Note that the linked lists must retain their original structure after the function returns.
     *
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * Output: Intersected at '8'
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode (){}
        ListNode (int val){this.val = val;}
        ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * Brutal
         * The way the answer design its code is delicate and swift,
         * but the core is too simple and poor, although it's the only way to solve it.
         * Above all, poor question certified.
         *
         * Time complexity: O(n)
         * Space complexity: O(1)
         */
        if (headA == null || headB == null)
            return null;

        ListNode h1 = headA, h2 = headB;
        int lengthA = 0, lengthB = 0;
        while (headA != null){
            headA = headA.next;
            lengthA++;
        }
        while (headB != null){
            headB = headB.next;
            lengthB++;
        }

        return intersect(h1, h2, lengthA, lengthB);
    }

    public static ListNode intersect(ListNode headA, ListNode headB, int lenA, int lenB){
        if (lenA < lenB)
            return intersect(headB, headA, lenB, lenA);
        while (lenA - lenB > 0){
            headA = headA.next;
            lenA--;
        }
        while (!headA.equals(headB) && lenA > 0){
            headA = headA.next;
            headB = headB.next;
            lenA--;
        }
        return lenA == 0 ? null : headA;
    }
}
