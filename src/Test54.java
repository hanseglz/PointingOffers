import java.awt.event.TextEvent;
import java.util.ArrayList;
import java.util.List;

public class Test54 {
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * 1 ≤ k ≤ 二叉搜索树元素个数
     */
    private static List<Integer> list = new ArrayList<>();

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public static int kthLargest(TreeNode root, int k){
        /**
         * 二叉搜索树的特点：中序遍历数组为递增顺序
         */
        inOrder(root);
        return list.get(list.size() - k);
    }

    public static void inOrder(TreeNode root){
        if (root == null)
            return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        System.out.println(kthLargest(root,3));
    }
}
