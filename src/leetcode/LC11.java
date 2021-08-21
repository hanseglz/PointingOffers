package leetcode;

public class LC11 {
    /**
     * 11. Container With Most Water
     *
     * Given n non-negative integers a1, a2, ..., an,
     * where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
     * Find two lines, which, together with the x-axis forms a container,
     * such that the container contains the most water.
     * Notice that you may not slant the container.
     *
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
     * In this case, the max area of water (blue section) the container can contain is 49.
     */
    public static int maxArea(int[] height){
        /**
         * The only way to achieve O(n) time complexity is using two pointers for this question.
         * The 1st pointer points at the head and another one points at the end.
         * To begin with, since the area is always decided by the shorter line (and width),
         * we always move the pointer which pointing at the shorter line closer to the other pointer,
         * and save the area for each time to get the max one.
         * The math principle of this algorithm is a liiiiittle bit complicated but it works.
         */
        int res = 0;
        int head = 0, tail = height.length - 1;

        while (head < tail){
            int line1 = height[head], line2 = height[tail];
            res = Math.max(res, Math.min(line1, line2) * (tail - head));
            if (line1 < line2)
                head++;
            else
                tail--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
