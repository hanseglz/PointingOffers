package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LC76 {
    /**
     * 76. Minimum Window Substring
     *
     * Given two strings s and t of lengths m and n respectively,
     * return the minimum window substring of s such that
     * every character in t (including duplicates) is included in the window.
     * If there is no such substring, return the empty string "".
     * The testcases will be generated such that the answer is unique.
     * A substring is a contiguous sequence of characters within the string.
     *
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     */
    public static String minWindow(String s, String t) {
        /**
         * Using two pointers and a hashmap, the typical solution, but I didn't make it.
         */
        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            if (!hashMap.containsKey(t.charAt(i)))
                hashMap.put(t.charAt(i), 1);
            else
                hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) + 1);
        }

        int head = 0, tail = 0;
        int count = 0;
        int res = s.length() + 1, lFlag = 0, rFlag = s.length() + 1;
        while (tail < s.length()){
            if (hashMap.containsKey(s.charAt(tail))){
                hashMap.put(s.charAt(tail), hashMap.get(s.charAt(tail))-1);
                if (hashMap.get(s.charAt(tail)) >= 0)
                    count++;
            }
            if (t.length() == count){
                lFlag = res > tail - head + 1 ? head : lFlag;
                rFlag = res > tail - head + 1 ? tail : rFlag;
                res = Math.min(res, tail - head + 1);
                count--;
                hashMap.put(s.charAt(head), hashMap.get(s.charAt(head)) + 1);
                head++;
                while (head <= tail){
                    if (hashMap.containsKey(s.charAt(head))){
//                        hashMap.put(s.charAt(head), hashMap.get(s.charAt(head)) + 1);
//                        if (hashMap.get(s.charAt(head)) >= 0)
//                            count--;
                        break;
                    }
                    head++;
                }
            }
            if (s.charAt(head) == s.charAt(tail) && hashMap.containsKey(s.charAt(tail)) && hashMap.get(s.charAt(tail)) < 0){
                hashMap.put(s.charAt(head), hashMap.get(s.charAt(head)) + 1);
                head++;
                while (head <= tail){
                    if (hashMap.containsKey(s.charAt(head))){
                        break;
                    }
                }
            }
            tail++;
        }

        return s.substring(lFlag, rFlag+1);
    }

    public static String minWindowAnswer(String s, String t){

        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        int[] tmap = new int[256]; //store the count of each character in t
        boolean[] tbmap = new boolean[256]; //store the appearance of each character in t

        for (int i = 0; i < t.length(); i++){
            tmap[t.charAt(i)]++;
            tbmap[t.charAt(i)] = true;
        }

        int i = 0, j = 0; //i and j stores the start and end index of substring
        int found  = 0; //found stores how many letters in t has been found in s
        int len = Integer.MAX_VALUE;
        String res = "";

        while(j < s.length()){
            char cj = s.charAt(j);
            if(found < t.length()){  // we haven't found all the letters in t
                if(tbmap[cj]){
                    if(tmap[cj] > 0) {   //the times cj appear in s is smaller than the times appears in t
                        found++;
                    }
                    tmap[cj]--;
                }
                j++;
            }

            while(found == t.length()){
                char ci = s.charAt(i);
                if(!tbmap[ci]) i++;  //ci in s is not in t
                else if (tmap[ci] < 0){  //ci appears more times in s than t
                    tmap[ci]++;
                    i++;
                }else{
                    if(j-i < len){
                        res = s.substring(i, j);
                        len = j - i;
                    }
                    found--;
                    tmap[ci]++;
                    i++;
                }
            }

        }

        return res;
    }
    
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindowAnswer(s,t));
    }
}
