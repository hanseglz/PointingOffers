
public class Test24 {
    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * 0 <= 节点个数 <= 5000
     *
     * 两种解法，分别为迭代和递归
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static ListNode reverserList(ListNode head){
        /**
         * 迭代解法
         * 从头到尾进行迭代，每次取三个节点
         *
         * 时间复杂度：O(n)
         */
        if (head == null || head.next == null)
            return head;
        ListNode pre = null,cur = head, nxt;
        while (cur != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public static ListNode reverseList2(ListNode head){
        /**
         * 递归算法
         * 从尾到头进行递归
         * 非常精妙的一种算法，具体推导不详细展开。。
         *
         * 时间复杂度：O(n)
         */
        if (head == null || head.next == null)
            return head;
        else{
            ListNode node = reverseList2(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }
}
