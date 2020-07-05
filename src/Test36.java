import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Test36 {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     */
    private static Queue<Node> queue = new LinkedList<>();

    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Node treeToDoublyList(Node root){
        /**
         * 对二叉搜索树中序遍历的顺序，即为所有节点值递增的顺序
         */
        if (root == null)
            return root;
        inOrder(root);
        root = queue.poll();
        Node prev = root;
        if (!queue.isEmpty())
            root.right = queue.peek();
        else{
            root.left = root;
            root.right = root;
            return root;
        }
        while (!queue.isEmpty()){
            Node node = queue.poll();
            node.left = prev;
            if (queue.peek() != null)
                node.right = queue.peek();
            else{
                node.right = root;
                root.left = node;
                break;
            }
            prev = node;
        }
        return root;
    }

    public static void inOrder(Node root){
        if (root == null)
            return;
        if (root.left != null)
            inOrder(root.left);
        queue.add(root);
        if (root.right != null)
            inOrder(root.right);
        return;
    }

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.right = node7;
        node6.left = node5;

        Node node8 = new Node(0);
        Node node9 = new Node(-1);
        node8.left = node9;
        System.out.println(treeToDoublyList(node4).right.val);
    }
}
