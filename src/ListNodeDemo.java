import java.util.List;

public class ListNodeDemo {

    private static ListNode head = new ListNode(0);

    public static class ListNode{
        int val;
        ListNode next;
        ListNode (int x) {val = x;}
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        for (int i = 0; i < 5; i++){
            ListNode node = new ListNode(nums[i]);
            head.next = node;
            head = node;
        }
        System.out.println(head.next);
    }
}
