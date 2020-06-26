
public class Test18 {
    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     *
     * 考察对链表的掌握程度，比较简单，故没有写main函数进行调试
     */
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static ListNode deleteNode(ListNode head, int val){
        if (head.val == val){
            return head.next;
        }
        ListNode node = head;
        while (node.next != null){
            if (node.next.val == val){
                if (node.next.next == null){
                    node.next = null;
                }else{
                    node.next = node.next.next;
                }
                break;
            }
            node = node.next;
        }
        return head;
    }
}
