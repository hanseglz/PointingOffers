import java.util.HashMap;

public class Test35 {
    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。
     * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     */
    private static Node newHead = new Node(0);
    private static HashMap<Node, Node> hashMap = new HashMap<>();

    public static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head){
        if (head == null)
            return head;
        addLinkedList(head, newHead);
        addRandom(head, newHead.next);
        return newHead.next;
    }

    public static void addLinkedList(Node head, Node newTail){
        if (head == null)
            return;
        Node node = new Node(head.val);
        hashMap.put(head, node);
        if (newHead.next == null)
            newHead.next = node;
        else
            newTail.next = node;
        addLinkedList(head.next, node);
        return;
    }

    public static void addRandom(Node head, Node newNode){
        if (head == null)
            return;
        newNode.random = hashMap.get(head.random);
        addRandom(head.next, newNode.next);
        return;
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        Node res = copyRandomList(node1);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
