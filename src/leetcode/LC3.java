package leetcode;

import java.util.HashMap;

public class LC3 {
    /**
     * 3. Longest Substring Without Repeating Characters
     *
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public static int lengthOfLongestSubstring(String s) {
        /**
         * Typical substring question, using two pointers and a hashmap.
         */
        if (s.length() == 0)
            return 0;

        int res = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (end < s.length()){
            if (!hashMap.containsKey(s.charAt(end))){
                hashMap.put(s.charAt(end), end);
                end++;
            }else{
                res = Math.max(res, end - start);
//                start = hashMap.get(s.charAt(end)) + 1;
                while (start < hashMap.get(s.charAt(end))){
                    hashMap.remove(s.charAt(start));
                    start++;
                }
                start++;
                hashMap.put(s.charAt(end), end);
                if (end != s.length() - 1)
                    end++;
                else
                    break;
            }
        }

        return Math.max(res, end - start);
    }

    public static void main(String[] args) {
        String str = "ewwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
