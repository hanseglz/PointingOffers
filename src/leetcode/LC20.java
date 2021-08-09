package leetcode;

import java.util.*;

public class LC20 {
    /**
     * 20. Valid Parentheses
     *
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * An input string is valid if:
     * 1. Open brackets must be closed by the same type of brackets.
     * 2. Open brackets must be closed in the correct order.
     *
     * Input: s = "()[]{}"
     * Output: true
     * Input: s = "([)]"
     * Output: false
     */

    public static boolean isValid(String s) {
        /**
         * Using stack
         */
        if (s.length() % 2 == 1)
            return false;
        if (s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');
        for (int i = 0; i < s.length(); i++){
            if (hashMap.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else if (stack.empty()){
                return false;
            }else{
                if (hashMap.get(stack.peek()) != s.charAt(i))
                    return false;
                else
                    stack.pop();
            }
        }
        //in case of "(("
        return stack.empty();
    }

    public static void main(String[] args) {
        String str = "((";
        System.out.println(isValid(str));
    }
}
