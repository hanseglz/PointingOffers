package leetcode;

import java.util.Stack;

public class LC9 {
    /**
     * 9. Palindrome Number
     *
     * Given an integer x, return true if x is palindrome integer.
     * An integer is a palindrome when it reads the same backward as forward.
     * For example, 121 is palindrome while 123 is not.
     *
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121.
     * From right to left, it becomes 121-. Therefore it is not a palindrome.
     */
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        Stack<Integer> stack = new Stack<>();
        int flag = x;
        while (flag != 0){
            stack.push(flag % 10);
            flag /= 10;
        }
        int newNum = 0, count = 1;
        while (!stack.empty()){
            newNum += stack.pop() * count;
            count *= 10;
        }
        if (newNum == x)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
}
