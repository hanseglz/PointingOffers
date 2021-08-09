package leetcode;

public class LC121 {
    /**
     * 121. Best Time to Buy and Sell Stock
     *
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock
     * and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction.
     * If you cannot achieve any profit, return 0.
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */

    public static int maxProfit(int[] prices) {
        /**
         * Time complexity equals to O(n) but still only beat up less than 20%.
         * Personal speaking, not an ideal problem.
         */
        if (prices.length == 1)
            return 0;

        boolean hasAns = false;
        int res = 0, flag = -1;
        for (int i = 0; i < prices.length-1; i++){
            if (prices[i] < prices[i+1]){
                hasAns = true;
                if (flag < 0 || prices[flag] > prices[i]){
                    flag = i;
                }
                res = Math.max(res, prices[i+1] - prices[flag]);
            }
        }

        return hasAns ? res : 0;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
