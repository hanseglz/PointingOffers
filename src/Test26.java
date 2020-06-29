
public class Test26 {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即A中有出现和B相同的结构和节点值。
     * 例如:
     * 给定的树 A:
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 B：
     *    4 
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     * 0 <= 节点个数 <= 10000
     */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    public static boolean isSubTree(TreeNode A, TreeNode B){
        /**
         * 没有什么特殊的方法，遍历就完事儿了
         * 本题主要考验对树结构的操作熟练程度
         * 需要设计两个方法，一个用来（深度）遍历大树A，一个用来判断当前树节点是否相等
         */
        if (A == null || B == null)
            return false;

        return isSubTree(A.right, B) || isSubTree(A.left, B) || isEqual(A, B);
    }

    public static boolean isEqual(TreeNode A, TreeNode B){
        /**
         * 对树的深度/先序遍历，重要！
         */
        if (B == null)
            return true;
        if (A == null)
            return false;
        if (A.val != B.val)
            return false;
        else
            return isEqual(A.left, B.left) && isEqual(A.right, B.right);
    }
}
