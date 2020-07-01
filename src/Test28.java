
public class Test28 {
    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     * 0 <= 节点个数 <= 1000
     */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    public static boolean isSymmetric(TreeNode root){
        /**
         * 首先建立该树的镜面树（利用Test27的内容，但并非完全相同，27是在root原地修改，这里需要保持root，同时创建一个新的newRoot）
         * 然后判断原树与镜面树是否相同即可
         */
        if (root == null)
            return true;

        TreeNode newRoot = mirrorTree(root);
        return same(root, newRoot);
    }

    public static boolean same(TreeNode root, TreeNode newRoot){
        if (root == null && newRoot == null)
            return true;
        else if (root == null || newRoot == null)
            return false;

        if (root.val != newRoot.val)
            return false;
        else
            return same(root.left, newRoot.left) && same(root.right, newRoot.right);
    }

    public static TreeNode mirrorTree(TreeNode root){
        if (root == null)
            return root;

        //这里不能直接TreeNode newRoot = root，否则root后面的结构会全都贴到newRoot上，对newRoot修改就是对root修改！
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = mirrorTree(root.right);
        newRoot.right = mirrorTree(root.left);

        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = null;
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = null;
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(isSymmetric(node1));
    }
}
