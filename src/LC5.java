
public class LC5 {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 本题大体上从易到难一共有4种解法：
     *      1.暴力解法 —— 基础
     *      2.动态规划 —— 必须掌握
     *      3.中心扩散 —— 必须了解
     *      4.Manacher算法 —— 知道即可
     */
    public static String longestPalindrome(String s){
        /**
         * 1.暴力解法（Brute Force）
         * 由一个时间复杂度为O(n^2)，负责遍历s中每个子字符串的方法，和一个时间复杂度为O(n)，负责判断每个子字符串是否为回文串的方法构成
         * 时间复杂度：O(n^3)
         * 空间复杂度：O(n)
         */
        if (s.length() == 0 || s.length() == 1)
            return s;

        int maxLen = 1;
        String res = s.substring(0,1);
        for (int i = 0; i < s.length() - 1; i++){
            for (int j = i + 1; j < s.length(); j++){
                //可以先判断当前子字符串长度是否大于maxLen，若是再判断其是否为回文串
                if (reverse(s.substring(i,j+1)) && j - i + 1 > maxLen){
                    res = maxLen < j - i + 1 ? s.substring(i,j+1) : res;
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return res;
    }

    public static boolean reverse(String s){
        int len = s.length();
        int head = 0, tail = len - 1;
        while (head < tail){
            if (s.charAt(head) == s.charAt(tail)){
                head++;
                tail--;
            }
            else
                return false;
        }
        return true;
    }

    public static String longestPalindrome2(String s){
        /**
         * 2.动态规划
         * 「动态规划」的一个关键的步骤是想清楚「状态如何转移」。事实上，「回文」天然具有「状态转移」性质：
         *          一个回文去掉两头以后，剩下的部分依然是回文（这里暂不讨论边界情况）；
         * 依然从回文串的定义展开讨论：
         *      如果一个字符串的头尾两个字符都不相等，那么这个字符串一定不是回文串；
         *      如果一个字符串的头尾两个字符相等，才有必要继续判断下去。
         *          如果里面的子串是回文，整体就是回文串；
         *          如果里面的子串不是回文串，整体就不是回文串。
         * 即：在头尾字符相等的情况下，里面子串的回文性质据定了整个子串的回文性质，这就是状态转移。
         * 因此可以把「状态」定义为原字符串的一个子串是否为回文子串。
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n^2)
         */
        int len = s.length();
        if (len < 2)
            return s;

        boolean[][] judge = new boolean[len][len];
        int maxLen = 1;
        String res = s.substring(0,1);

        for (int i = 0; i < len; i++){
            judge[i][i] = false;
        }
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if (s.charAt(j) != s.charAt(i))
                    judge[i][j] = false;
                else{
                    if (j - i + 1 < 4){
                        judge[i][j] = true;
                    }
                    else{
                        judge[i][j] = judge[i+1][j-1];
                    }
                }

                if (judge[i][j]){
                    res = j - i + 1 > maxLen ? s.substring(i,j+1) : res;
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return res;
    }

    public static String longestPalindrome3(String s){
        /**
         * 3.中心扩散法
         * 枚举可能出现的回文子串的“中心位置”，从“中心位置”尝试尽可能扩散出去，得到一个回文串。
         * 在这里要注意一个细节：回文串在长度为奇数和偶数的时候，“回文中心”的形式是不一样的。
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(1)
         */
        int len = s.length();
        if (len < 2)
            return s;
        int maxLen = 1;
        String res = s.substring(0, 1);

        for (int i = 0; i < len - 1; i++){
            String oddStr = centerOpen(s, i, i);
            String evenStr = centerOpen(s, i, i + 1);
            String tempRes = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            res = tempRes.length() > maxLen ? tempRes : res;
            maxLen = res.length();
        }

        return res;
    }

    public static String centerOpen(String s, int left, int right){
        int len = s.length();
        int i = left, j = right;
        while (i >= 0 && j < len){
            if (s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else{
                break;
            }
        }
        return s.substring(i + 1, j);
    }

    public static String longestPalindrome4(String s){
        /**
         * 4.Manacher算法
         * 不用掌握，面试的时候绝大多数情况下不会要求写这个算法，了解思想即可。
         * Manacher 算法，被中国程序员戏称为“马拉车”算法。它专门用于解决“最长回文子串”问题，是基于“中心扩散法”，采用和 kmp 算法类似的思想。
         * 具体内容参考：
         * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
         *
         * 时间复杂度：O(n)
         */
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome3("abcb"));
    }
}
