package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC101 {
    /**
     * 101. Symmetric Tree
     *
     * Given the root of a binary tree,
     * check whether it is a mirror of itself (i.e., symmetric around its center).
     *
     * Input: root = [1,2,2,3,4,4,3]
     * Output: true
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

    public static boolean isSymmetric(TreeNode root){
        /**
         * The idea of inOrder traverse for this question is useless.(i.e. [1,2,2,2,null,2])
         * Refer to Test27 & Test28(exactly the same as this one), we can use the idea of recursive.
         *
         * Time complexity: O(n)
         * Space complexity: O(n)
         */
        if (root == null)
            return false;

        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null)
            return true;
        else if (node1 == null || node2 == null)
            return false;
        else if (node1.val != node2.val)
            return false;

        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    public static boolean isSymmetric2(TreeNode root){
        /**
         * Or you can also use the idea of iterative, a bit more complicated.
         *
         * Time complexity: O(n)
         * Space complexity: O(n)
         */
        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null)
                return true;
            else if (node1 == null || node2 == null)
                return false;
            else if (node1.val != node2.val)
                return false;

            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node2.left);
            queue.add(node1.right);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2, null, n5);
        TreeNode n2 = new TreeNode(2, n4, null);
        TreeNode n1 = new TreeNode(1, n2, n3);
        System.out.println(isSymmetric(n1));
    }
}
