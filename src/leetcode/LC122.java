package leetcode;

public class LC122 {
    /**
     * 122. Best Time to Buy and Sell Stock II
     *
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * Find the maximum profit you can achieve.
     * You may complete as many transactions as you like
     * (i.e., buy one and sell one share of the stock multiple times).
     * Note: You may not engage in multiple transactions simultaneously
     * (i.e., you must sell the stock before you buy again).
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     */
    public static int maxProfit(int[] prices) {
        /**
         * Da Kai Nao Dong Xi Lie ......
         */
        /*if (prices.length == 1)
            return 0;
        else if (prices.length == 2)
            return Math.max(0, prices[1] - prices[0]);

        int res = 0;
        for (int left = 0, right = 1; right < prices.length;){
            if (prices[left] >= prices[right]){
                left++;
                right++;
                continue;
            } else {
                while (right < prices.length - 1 && prices[right] <= prices[right+1]){
                    right++;
                }
                res += prices[--right] - prices[left];
            }
        }*/
        int sum = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++){
            profit = prices[i] - prices[i-1];
            sum += Math.max(0, profit);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(maxProfit(arr));
    }
}
