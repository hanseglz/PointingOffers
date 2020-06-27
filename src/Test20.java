
public class Test20 {
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
     * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
     *
     * 一道题目要求非常不规范、不严谨的题，大概率不会在面试中碰到。
     */
    public static boolean isNumber(String s){
        int len = s.length();
        boolean dotExist = false;
        boolean expExist = false;
        for (int i = 0; i < len; i++){
            if (!judgeNumber(s.charAt(i))){
                if (s.charAt(i) == '+' || s.charAt(i) == '-'){
                    if (i == 0 && len > 1)
                        continue;
                    else if (s.charAt(i) == '-' && s.charAt(i - 1) == 'e')
                        continue;
                    else
                        return false;
                }
                else if (s.charAt(i) == '.'){
                    if (dotExist)
                        return false;
                    if (i == 0 && len > 1){
                        if (judgeNumber(s.charAt(i + 1))){
                            dotExist = true;
                        }else
                            return false;
                    }else if (i == len - 1 && len > 1){
                        if (judgeNumber(s.charAt(i - 1))){
                            dotExist = true;
                        }else
                            return false;
                    }else if (i != 0 && i != len - 1){
                        if (judgeNumber(s.charAt(i - 1)) && judgeNumber(s.charAt(i + 1))){
                            dotExist = true;
                        }else
                            return false;
                    }else
                        return false;
                }
                else if (s.charAt(i) == 'e'){
                    if (i == 0 || i == len - 1)
                        return false;
                    if (expExist)
                        return false;
                    expExist = true;
                }
                else if (s.charAt(i) == ' '){
                    if (i == 0 && len > 1){
                        if (judgeNumber(s.charAt(i + 1))){
                            continue;
                        }else
                            return false;
                    }else if (i == len - 1 && len > 1){
                        if (judgeNumber(s.charAt(i - 1))){
                            continue;
                        }else
                            return false;
                    }else
                        return false;
                }
                else
                    return false;
            }
        }
        if (dotExist && expExist)
            return false;
        return true;
    }

    public static boolean judgeNumber(char chr){
        if (chr == '0' || chr == '1' || chr == '2' || chr == '3' ||
                chr == '4' || chr == '5' || chr == '6' || chr == '7' ||
                chr == '8' || chr == '9')
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String str = "1 ";
        System.out.println(isNumber(str));
    }
}
