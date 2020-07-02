import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test33 {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * 参考以下这颗二叉搜索树：
     *      5
     *     / \
     *    2   6
     *   / \
     *  1   3
     *  [1,6,3,2,5]返回 false
     *  [1,3,2,6,5]返回 true
     */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    public static boolean verifyPostOrder(int[] postOrder){
        /**
         * 二叉搜索树的特点：左子树 < 根 < 右子树
         * 所以根据后序遍历数组，可以得到唯一的二叉搜索树，具体方法为：
         * 首先数组的最后一位一定为根节点
         * 确定根节点后，根据与根节点比大小，可以确定左子树和右子树在数组中的分界线
         * 对于左子树部分的最后一位即为左子树的根节点，右子树同理，递归以上步骤
         * 递归的终止条件为根节点左侧没有多余的值
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         */
        if (postOrder == null || postOrder.length <= 2)
            return true;

        int len = postOrder.length;
        TreeNode root = new TreeNode(postOrder[len - 1]);
        int i = 0;
        for (; i < len - 1; i++){
            if (postOrder[i] > root.val)
                break;
        }
        int j = i--;
        for (; j < len - 1; j++){
            if (postOrder[j] < root.val){
                return false;
            }
        }
        boolean left = verifyPostOrder(Arrays.copyOfRange(postOrder,0,i+1));
        boolean right = verifyPostOrder(Arrays.copyOfRange(postOrder, i + 1,len - 1));
        return left && right;
    }

    public static void main(String[] args) {
        int[] test = {1,2,5,10,6,9,4,3};
        System.out.println(verifyPostOrder(test));
    }
}
