public class ListNodeDemo {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode (int x) {val = x;}
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(1);
        head.next = tail;
        ListNode flag = head;
        System.out.println(flag.val);
        System.out.println(flag.next.val);
    }
}
