package leetcode;

import java.util.*;

public class LC49 {
    /**
     * 49. Group Anagrams
     *
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        /**
         *
         */
        int len = strs.length;
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> hashMap = new HashMap<>();

        char[][] chars = new char[len][];
        for (int i = 0; i < len; i++)
            chars[i] = strs[i].toCharArray();

        for (int i = 0; i < len; i++){
            char[] cs = chars[i];
            Arrays.sort(cs);
            if (!hashMap.containsKey(Arrays.toString(cs))){
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                hashMap.put(Arrays.toString(cs), list);
            } else {
                List<String> list = hashMap.get(Arrays.toString(cs));
                list.add(strs[i]);
                hashMap.put(Arrays.toString(cs), list);
            }
        }

        for (Map.Entry<String, List<String>> entry: hashMap.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(strings);
        for (List<String> str : res){
            System.out.println(str);
        }
    }
}
