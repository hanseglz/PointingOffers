import java.util.Arrays;

public class Test25 {
    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 0 <= 链表长度 <= 1000
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode (int x) {val = x;}
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        /**
         * 将l1和l2中所有节点的值存在一个Arrays中，利用Arrays的API排序后，依次放入新链表
         * 方法高效，但代码十分不美观。。。
         *
         * 时间复杂度：O(n)
         */
        if (l1 == null && l2 == null)
            return null;

        int len1 = 0, len2 = 0;
        int[] nums = new int[2000];
        if (l1 != null){
            while (l1 != null){
                nums[len1] = l1.val;
                l1 = l1.next;
                len1++;
            }
        }
        if (l2 != null){
            while (l2 != null){
                nums[len1 + len2] = l2.val;
                l2 = l2.next;
                len2++;
            }
        }
        int[] res = new int[len1 + len2];
        for (int i = 0; i < len1 + len2; i++)
            res[i] = nums[i];
        Arrays.sort(res);
        ListNode head = new ListNode(res[0]);
        ListNode flag = head;
        if (len1 + len2 == 1)
            return head;
        else{
            for (int i = 1; i < len1 + len2; i++){
                ListNode node = new ListNode(res[i]);
                flag.next = node;
                flag = node;
            }
        }
        return head;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        /**
         * 标准做法，创建新链表，将l1与l2的元素依次放入
         * 甚至可以使用递归
         */
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode flag = head;
        while (l1 != null && l2 != null){
            ListNode node;
            if (l1.val < l2.val){
                node = l1;
                flag.next = node;
                l1 = l1.next;
            }else{
                node = l2;
                flag.next = node;
                l2 = l2.next;
            }
            flag = node;
        }
        if (l1 == null)
            flag.next = l2;
        else
            flag.next = l1;
        return head.next;
    }
}

