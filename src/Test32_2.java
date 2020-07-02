import java.util.*;

public class Test32_2 {
    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        /**
         * BFS
         * 比Test32_1多了一个要求，即分层输出
         * 由于while循环每次固定最多处理2个值，即当前root的左右子树，为了实现分层输出，可以在while内设置for循环，循环次数为queue的size
         * 关键在于理解while循环的内在逻辑
         */
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
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
