import java.util.Arrays;
import java.util.HashMap;

public class Test07 {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如，给出：
     *      前序遍历 preorder = [3,9,20,15,7]
     *      中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 0 <= 节点个数 <= 5000
     */

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder){
        /**
         * 核心思想：递归！
         * 首先preorder中第一个元素为root，对照root在inorder中的位置，确定左右子树；
         * 然后依法炮制，确定左右子树中的root，并进一步确定左右子树的左右子树，以此类推。
         * 递归结束条件：当preorder/inorder数组中有且仅有一个元素，即叶子节点。
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        int len = preorder.length;
        if (len == 0){
            return null;
        }else if (len == 1){
            TreeNode leaf = new TreeNode(preorder[0]);
            leaf.right = null;
            leaf.left = null;
            return leaf;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < len; i++){
            if (inorder[i] == root.val){
                int leftLength = i;
                int rightLength = len - i - 1;
                if (leftLength == 0){
                    root.left = null;
                }else{
                    root.left = buildTree(Arrays.copyOfRange(preorder,1,i+1), Arrays.copyOfRange(inorder,0,i));
                }
                if (rightLength == 0){
                    root.right = null;
                }else{
                    root.right = buildTree(Arrays.copyOfRange(preorder,i+1,len), Arrays.copyOfRange(inorder,i+1,len));
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder,inorder));
    }
}
