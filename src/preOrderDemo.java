import java.util.*;

public class preOrderDemo {

    private static List<Integer> res = new ArrayList<>();

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    public static List<Integer> preorderTraversal(TreeNode root){
        if (root == null)
            return res;
        preOrder(root);
        return res;
    }

    public static void preOrder(TreeNode root){
        if (root == null)
            return;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
        return;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        System.out.println(preorderTraversal(node1));
    }
}
