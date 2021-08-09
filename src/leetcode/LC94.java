package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC94 {
    /**
     * 94. Binary Tree Inorder Traversal
     *
     * Given the root of a binary tree,
     * return the inorder traversal of its nodes' values.
     *
     * Input: root = [1,null,2,3]
     * Output: [1,3,2]
     */

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> list = new ArrayList<>();

    public static List<Integer> inorderTraversal(TreeNode root) {
        /**
         * Recursive approach
         *
         * Time complexity : O(n)
         */
        if (root == null)
            return list;

        if (root.left != null)
            list = inorderTraversal(root.left);
        list.add(root.val);
        if (root.right != null)
            list = inorderTraversal(root.right);

        return list;
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n3,null);
        TreeNode n1 = new TreeNode(1, null, n2);
        list = inorderTraversal(n1);
        for (int val : list){
            System.out.println(val);
        }
    }
}
