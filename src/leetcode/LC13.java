package leetcode;

import java.util.HashMap;

public class LC13 {
    /**
     * 13. Roman to Integer
     *
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * For example, 2 is written as II in Roman numeral, just two one's added together.
     * The number 12 is written as XII, which is simply X + II.
     * The number 27 is written as XXVII, which is XX + V + II.
     * Given a roman numeral, convert it to an integer.
     *
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    public static int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int res = hashMap.get(s.charAt(s.length()-1));
        for (int i = s.length() - 2; i > -1; i--){
            if (hashMap.get(s.charAt(i+1)) > hashMap.get(s.charAt(i))){
                res -= hashMap.get(s.charAt(i));
            }else
                res += hashMap.get(s.charAt(i));
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }
}
