import java.util.*;

public class Test32_3 {
    /**
     * 请实现一个函数按照之字形顺序打印二叉树，
     * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * 关键点在于对LinkedList的addFirst方法的熟练掌握，以及Queue, ArrayList, LinkedList之间关系的掌握
     */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                if (res.size() % 2 != 0)
                    temp.addFirst(node.val);
                else
                    temp.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5= new TreeNode(1);
        TreeNode node6 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.left = node5;
        node1.right = node6;
        node2.left = node3;
        node2.right = node4;
        System.out.println(Arrays.deepToString(levelOrder(root).toArray()));
    }
}
