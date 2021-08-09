package leetcode;

import java.util.Arrays;

public class LC108 {
    /**
     * 108. Convert Sorted Array to Binary Search Tree
     *
     * Given an integer array nums where the elements are sorted in ascending order,
     * convert it to a height-balanced binary search tree.
     * A height-balanced binary tree is a binary tree
     * in which the depth of the two subtrees of every node never differs by more than one.
     *
     * Input: nums = [-10,-3,0,5,9]
     * Output: [0,-3,9,-10,null,5]
     * Explanation: [0,-10,5,null,-3,null,9] is also accepted.
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        /**
         * Since the sorted array must be the in-order traverse of the binary search tree,
         * use recursive to split the array up and build the tree from the leaves.
         */
        if (nums.length == 1)
            return new TreeNode(nums[0]);

        int len = nums.length;
        TreeNode root = new TreeNode(nums[len/2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len/2));
        if (len > 2)
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, len/2+1, len));
        else
            root.right = null;
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};

    }
}
