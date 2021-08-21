package leetcode;

public class LC5 {
    /**
     * 5. Longest Palindromic Substring
     *
     * Given a string s, return the longest palindromic(回文) substring in s.
     *
     * Input: s = "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     */
    public static String longestPalindrome(String s) {
        /**
         * Already did this one before, Chinese version of solving methods can be referred.
         * Mainly 4 solutions: brutal, DP, central spreading, Manacher Algorithm.
         * Skip the first one, the second one and the third one are recommended, especially DP, vital one.
         * The Manacher Algorithm is very abstract, it's ok to just have a bit of look at it currently.
         *
         * Here we will achieve the DP.
         * Time complexity: O(n^2)
         * Space complexity: O(n^2)
         */
        if (s.length() < 2)
            return s;

        int len = s.length();
        int maxLen = 1;
        String res = s.substring(0,1);
        boolean[][] judge = new boolean[len][len];
        for (int i = 0; i < len; i++){
            judge[i][i] = false;
        }

        for (int i = 1; i < len; i++){
            for (int j = 0; j < i; j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (i - j < 3){
                        judge[j][i] = true;
                    }else{
                        judge[j][i] = judge[j+1][i-1];
                    }
                }
                if (judge[j][i]){
                    res = (i-j+1) > maxLen ? s.substring(j,i+1) : res;
                    maxLen = Math.max(i-j+1, maxLen);
                }
            }
        }

        return res;
    }

    public static int isPalindromic(int i, String s){
        int j = 1;
        int len = 1;
        while (i - j > -1 && i + j < s.length()){
            if (s.charAt(i-j) == s.charAt(i+j)){
                j++;
                len = len + 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }
}
