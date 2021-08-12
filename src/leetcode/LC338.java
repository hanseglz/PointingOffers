package leetcode;

import java.util.Arrays;

public class LC338 {
    /**
     * 338. Counting Bits
     *
     * Given an integer n, return an array ans of length n + 1
     * such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
     *
     * Input: n = 5
     * Output: [0,1,1,2,1,2]
     * Explanation:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * 3 --> 11
     * 4 --> 100
     * 5 --> 101
     */
    public static int[] countBits(int n) {
        /**
         * Obviously, this question is testing us the ability to manipulate bit operations.
         */
        if (n == 0)
            return new int[]{0};
        else if (n == 1)
            return new int[]{0,1};

        int[] res = new int[n+1];
        for (int i = 0; i < res.length; i++){
            if (i == 0 || i == 1){
                res[i] = i;
                continue;
            }
            int count = 0, flag = i;
            while (flag != 0){
                if ((flag & 1) == 1)
                    count++;
                flag = flag >> 1;
            }
            res[i] = count;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
    }
}
