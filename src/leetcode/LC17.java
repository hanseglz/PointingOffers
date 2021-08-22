package leetcode;

import java.util.*;

public class LC17 {
    /**
     * Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations that the number could represent.
     * Return the answer in any order.
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * Note that 1 does not map to any letters.
     *
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Input: digits = "123"
     * Output: [adg,adh,adi,aeg,aeh,aei,afg,afh,afi,
     *          bdg,bdh,bdi,beg,beh,bei,bfg,bfh,bfi,
     *          cdg,cdh,cdi,ceg,ceh,cei,cfg,cfh,cfi]
     */
    public static List<String> letterCombinations(String digits) {
//        if (digits.equals(""))
//            return new ArrayList<>();
//
//        List<String> res = new ArrayList<>();
        /**
         * Nothing special for the algorithm, just extremely delicate FIFO using queue.
         */
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        String str = "23";
        System.out.println(letterCombinations(str));
    }
}
