package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC763 {
    /**
     * 763. Partition Labels
     *
     * You are given a string s. We want to partition the string into as many parts as possible
     * so that each letter appears in at most one part.
     * Return a list of integers representing the size of these parts.
     *
     * Input: s = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
     */

    public static List<Integer> res = new LinkedList<>();

    public static List<Integer> partitionLabels(String s) {
        if (s.length() == 1){
            res.add(1);
            return res;
        }

        //The hashmap store the index of the letter's last appearance
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            hashMap.put(s.charAt(i), i);
        }

        int flag = 0, start = 0, end = 0;
        while (end < s.length()){
            end = Math.max(end, hashMap.get(s.charAt(start)));
            if (start == end){
                res.add(end-flag+1);
                flag = start = end = end + 1;

                continue;
            }

            start++;
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(str));
    }
}
