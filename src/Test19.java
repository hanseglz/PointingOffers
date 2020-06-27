
public class Test19 {
    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
     * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
     */
    public static boolean isMatch(String s, String p){
        /**
         * 这道题没什么算法上的精妙解法，考的就是一个思路是否清晰，能否考虑到各种情况
         * 核心思想（但不是难点）是动态规划
         */
        //字符串与模式串完全相等的情况，包括了均为空串的情况
        if (s.equals(p))
            return true;
        //字符串非空，而模式串为空的情况，必false
        else if (p.length() ==0)
            return false;
        //模式串非空，而字符串为空的情况，需要讨论模式串是否为“?*?*...?*”的情况
        else if (s.length() == 0){
            if (p.length() % 2 != 0)
                return false;
            else{
                for (int i = 0; i < p.length();){
                    if (p.charAt(i + 1) != '*')
                        return false;
                    i += 2;
                }
                return true;
            }
        }

        //字符串&模式串均非空的情况
        int pGiven = 0, pAsked = 0, pAskedNext;
        int pLen = p.length();
        /*while (pGiven < sLen){
            if (s.charAt(pGiven) == p.charAt(pAsked) || p.charAt(pAsked) == '.'){
                if (pAsked == pLen - 1 && pGiven == sLen - 1)
                    return true;
                else if (pAsked == pLen - 1 && pGiven != sLen - 1)
                    return false;
                else if (p.charAt(pAsked + 1) != '*'){
                    pGiven++;
                    pAsked++;
                }else if (p.charAt(pAsked + 1) == '*') {
                    pGiven++;
                    if (pAsked < pLen - 2 && p.charAt(pAsked) == p.charAt(pAsked + 2)){
                        p = p.substring(0, pAsked + 2) + p.substring(pAsked + 3);
                        pLen--;
                    }
                }
            }else{
                if (pAsked == pLen - 1 || p.charAt(pAsked + 1) != '*'){
                    return false;
                }else if (p.charAt(pAsked + 1) == '*'){
                    if (pAsked == pLen - 2){
                        return false;
                    }else{
                        pAsked += 2;
                    }
                }
            }*/
        if (pLen > 1)
            pAskedNext = 1;
        else{
            if (s.charAt(pGiven) == p.charAt(pAsked) || p.charAt(pAsked) == '.')
                return isMatch(s.substring(1),"");
            else
                return false;
        }
        if (p.charAt(pAskedNext) == '*'){
            if (s.charAt(pGiven) == p.charAt(pAsked) || p.charAt(pAsked) == '.')
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            else
                return isMatch(s, p.substring(2));
        }else{
            if (s.charAt(pGiven) == p.charAt(pAsked) || p.charAt(pAsked) == '.')
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        }
    }

    public static boolean isMatch2(String A, String B) {
        /**
         * 官方标答
         * “我5年ACM金牌选手都不敢这么答”
         * （逃
         */
        // 如果字符串长度为0，需要检测下正则串
        if (A.length() == 0) {
            // 如果正则串长度为奇数，必定不匹配，比如 "."、"ab*",必须是 a*b*这种形式，*在奇数位上
            if (B.length() % 2 != 0) return false;
            int i = 1;
            while (i < B.length()) {
                if (B.charAt(i) != '*') return false;
                i += 2;
            }
            return true;
        }
        // 如果字符串长度不为0，但是正则串没了，return false
        if (B.length() == 0) return false;
        // c1 和 c2 分别是两个串的当前位，c3是正则串当前位的后一位，如果存在的话，就更新一下
        char c1 = A.charAt(0), c2 = B.charAt(0), c3 = 'a';
        if (B.length() > 1) {
            c3 = B.charAt(1);
        }
        // 和dp一样，后一位分为是 '*' 和不是 '*' 两种情况
        if (c3 != '*') {
            // 如果该位字符一样，或是正则串该位是 '.',也就是能匹配任意字符，就可以往后走
            if (c1 == c2 || c2 == '.') {
                return isMatch2(A.substring(1), B.substring(1));
            } else {
                // 否则不匹配
                return false;
            }
        } else {
            // 如果该位字符一样，或是正则串该位是 '.'，和dp一样，有看和不看两种情况
            if (c1 == c2 || c2 == '.') {
                return isMatch2(A.substring(1), B) || isMatch2(A, B.substring(2));
            } else {
                // 不一样，那么正则串这两位就废了，直接往后走
                return isMatch2(A, B.substring(2));
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s,p));
    }
}
