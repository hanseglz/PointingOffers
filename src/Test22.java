import java.util.List;

public class Test22 {
    /**
     * 输入一个链表，输出该链表中倒数第k个节点。
     * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static ListNode getKthFromEnd(ListNode head, int k){
        /**
         * 由于链表是单向的，所以不能像数组一样从队尾开始从后往前遍历
         * 首先需要得出链表的长度len
         * 然后通过向后查找len - k次得到目标节点
         *
         * 时间复杂度：O(n)
         */
        ListNode p1;
        p1 = head;
        int len = 1;
        while (p1.next != null){
            len++;
            p1 = p1.next;
        }
        while (len - k != 0){
            head = head.next;
            len--;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
