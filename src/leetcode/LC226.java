package leetcode;

import java.awt.event.TextEvent;

public class LC226 {
    /**
     * 226. Invert Binary Tree
     *
     * Given the root of a binary tree, invert the tree, and return its root.
     *
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode invertTree(TreeNode root){
        /**
         * The code is simple, and the key is to think the principle of tree-structure clearly.
         * When you run "root.left = node", the previous left leaf of the root is still exist,
         * but no longer being pointed by the root, substituted by "node".
         * So we can use TreeNode temp to store root.left from the very beginning.
         */
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n9 = new TreeNode(9);
        TreeNode n2 = new TreeNode(2, n1, n3);
        TreeNode n7 = new TreeNode(7, n6, n9);
        TreeNode n4 = new TreeNode(4, n2, n7);
        n4 = invertTree(n4);
//        System.out.println(n4.val);


        TreeNode test1 = new TreeNode(1);
        TreeNode test2 = new TreeNode(2);
        TreeNode test3 = new TreeNode(3);
        test1.left = test2;
        test1.right = test3;
        TreeNode temp = test1;
        System.out.println(temp.left.val);
        temp.right = test2;
        System.out.println(test1.right.val);
        System.out.println(test1.left.val);
    }
}
