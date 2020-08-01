import java.util.HashSet;

public class Test50 {
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * 0 <= s 的长度 <= 50000
     *
     * s = "abaccdeff"
     * 返回 "b"
     * s = ""
     * 返回 " "
     */
    public static char firstUniqueChar(String s){
        /**
         * 注意是“第一个”只出现一个的字符，也就是说 s 中可能有不止一个只出现一次的字符
         * 比较简单的一道题，注意 hashSet.add 的逻辑
         */
        if (s == null)
            return ' ';

        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            if (hashSet.add(s.charAt(i))){
                char chr = s.charAt(i);
                if (s.lastIndexOf(chr) == i)
                    return chr;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String str = "abaccdeff";
        System.out.println(firstUniqueChar(str));
    }
}
