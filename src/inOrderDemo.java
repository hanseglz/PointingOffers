import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class inOrderDemo {
    private static Queue<TreeNode> queue = new LinkedList<>();
    private static HashMap<TreeNode, Integer> hashMap = new HashMap<>();

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int x) {val = x;}
    }

    public static void inOrder(TreeNode root){
        if (root == null)
            return;
        hashMap.put(root, root.val);
        if (root.left != null)
            inOrder(root.left);
        queue.add(root);
        if (root.right != null)
            inOrder(root.right);
        return;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        node4.left = node3;
        node4.right = node6;
        node3.left = node1;
        node3.right = node2;
        node6.right = node7;
        node6.left = node5;
        inOrder(node4);
        while (!queue.isEmpty()){
            System.out.println(queue.poll().val);
        }
    }
}
