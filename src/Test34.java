import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.concurrent.TransferQueue;

public class Test34 {
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();

    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        /**
         * 从根节点到叶子结点递归遍历，采用DFS（中序和后序中根节点都不在首位，BFS不符合题目要求）
         * pathSum(root, sum) 函数：
         *  初始化： 结果列表 res ，路径列表 path 。
         *  返回值： 返回 res 即可。
         *
         * recur(root, tar) 函数：
         *  递推参数： 当前节点 root ，当前目标值 tar 。
         *  终止条件： 若节点 root 为空，则直接返回。
         *  递推工作：
         *      路径更新： 将当前节点值 root.val 加入路径 path ；
         *      目标值更新： tar = tar - root.val（即目标值 tar 从 sum 减至 00 ）；
         *      路径记录： 当 ① root 为叶节点 且 ② 路径和等于目标值 ，则将此路径 path 加入 res 。
         *      先序遍历： 递归左 / 右子节点。
         *      路径恢复： 向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop() 。
         *
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        recur(root, sum);
        return res;
    }

    public static void recur(TreeNode root, int target){
        if (root == null)
            return;
        list.add(root.val);
        target -= root.val;
        if (root.right == null && root.left == null && target == 0){
            //此处注意必须要new一个ArrayList，如果直接res.add(list)的话，由于list是全局变量，最后会变成空集
            res.add(new ArrayList<>(list));
        }
        if (root.left != null)
            recur(root.left, target);
        if (root.right != null)
            recur(root.right, target);
        target += root.val;
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        System.out.println(Arrays.deepToString(pathSum(root, 22).toArray()));
    }
}
