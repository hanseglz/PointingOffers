import java.util.HashMap;
import java.util.Map;

public class Test48 {
    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     *
     * s.length <= 40000
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    /**
     * 由于长度为 N 的字符串有 N * (N+1) / 2个子字符串，而遍历每个字符串需要 N 个单位时间，所以暴力解法的时间复杂度为O(N^3)
     * 本题必须采用动态规划（dp），最多可以将时间复杂度降低到O(n)
     * @param s
     * @return
     */
    //todo
    public static int lengthOfLongestSubstring(String s){
        /**
         * 动态规划 + hashtable
         * 哈希表统计： 遍历字符串 s 时，使用哈希表（记为 dic ）统计各字符最后一次出现的索引位置 。
         * 左边界 i 获取方式： 遍历到 s[j] 时，可通过访问哈希表 dic[s[j]] 获取最近的相同字符的索引 i 。
         *
         * 时间复杂度：O(n)
         * 空间复杂度：O(1)
         */
        Map<Character, Integer> map = new HashMap<>();
        int temp = 0, res = 0, i;
        if (s.length() == 0 || s.length() == 1)
            return s.length();
        for (int j = 0; j < s.length(); j++){
            if (map.getOrDefault(s.charAt(j), -1) == -1){
                map.put(s.charAt(j), j);
                temp++;
            }else{
                i = map.get(s.charAt(j));
                temp = j - i;
                map.put(s.charAt(j), j);
            }
            res = Math.max(res, temp);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
