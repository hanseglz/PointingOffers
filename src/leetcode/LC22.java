package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC22 {
    /**
     * 22. Generate Parentheses
     *
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     */

    public static List<String> res = new LinkedList<>();

    public static List<String> generateParenthesis(int n) {
        /*LinkedList<String> list = new LinkedList<>();
        if (n == 1){
            list.add("()");
            return list;
        }
        else if (n == 2){
            list.add("()()");
            list.add("(())");
            return list;
        }

        list.add("()()");
        list.add("(())");
        for (int i = 3; i <= n; i++){
            while (list.peek().length() == (i-1)*2){
                String str = list.remove();
                list.add("()"+str);
                list.add(str+"()");
                list.add("("+str+")");
            }
            list.remove();
        }
        return list;*/
        /**
         * Honestly I don't get the official solution at all......
         * However, there is one solution in Chinese comment section that I would preferred.
         * The key is to use recursion, and their is only one rule:
         * there must be more right parentheses left to be filled in than left parentheses.
         * So, if number of left parentheses equals to number of right parentheses (to be filled in),
         * the next character to be filled in must be a left parentheses.
         * Otherwise it could be both left or right parentheses.
         */
        if (n == 1){
            res.add("()");
            return res;
        }

        generateParenthesis("", n, n);
        return res;
    }

    public static void generateParenthesis(String str, int left, int right){
        if (left == 0 && right == 0){
            res.add(str);
            return;
        }

        if (left == right){ // number of left parentheses equals to number of right parentheses (to be filled in)
            generateParenthesis(str+"(", left-1, right);
        } else {    // left < right
            if (left > 0)
                generateParenthesis(str+"(", left-1, right);
            generateParenthesis(str+")", left, right-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
//["()(())()"] mine
//["(())(())"] answer