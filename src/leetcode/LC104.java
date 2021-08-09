package leetcode;

import apple.laf.JRSUIUtils;

public class LC104 {
    /**
     * 104. Maximum Depth of Binary Tree
     *
     * Given the root of a binary tree, return its maximum depth.
     * A binary tree's maximum depth is the number of nodes along the longest path
     * from the root node down to the farthest leaf node.
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode (int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {
        /**
         * Recursive
         */
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;

        return maxDepth(root, 0);
    }

    public static int maxDepth(TreeNode root, int depth){
        if (root == null)
            return depth;
        else
            return Math.max(maxDepth(root.left, depth+1), maxDepth(root.right, depth+1));
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(7);
        TreeNode n4 = new TreeNode(15, null, null);
        TreeNode n3 = new TreeNode(20, n4, n5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);
        System.out.println(maxDepth(n1));
    }
}
