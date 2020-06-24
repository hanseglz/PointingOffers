import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test06 {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 0 <= 链表长度 <= 10000
     */

    public static class ListNode{
        int val;    //节点的值
        ListNode next;  //下一个节点
        ListNode(int x) {val = x;}
    }

    public static int[] reversePrint(ListNode head){
        /**
         * 典型的“先进后出”，采用栈实现。
         */
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
            i++;
        }
        int[] res = new int[i];
        int j = 0;
        while(!stack.empty()){
            res[j++] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);
        root.next.next = new ListNode(2);
        System.out.println(Arrays.toString(reversePrint(root)));
    }
}
