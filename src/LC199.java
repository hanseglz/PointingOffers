import java.util.*;

public class LC199 {
    /**
     * 199. 二叉树的右视图
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     */
    private static List<Integer> res = new LinkedList<>();
    private static Queue<TreeNode> queue = new LinkedList<>();

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    public static List<Integer> rightSideView(TreeNode root){
        if (root == null)
            return res;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = size; i > 0; i--){
                if (i == 1)
                    res.add(queue.peek().val);
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        System.out.println(rightSideView(root));
    }
}
