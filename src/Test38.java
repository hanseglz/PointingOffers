import javax.swing.*;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Test38 {
    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * 1 <= s 的长度 <= 8
     */
    private static List<String> list = new LinkedList<>();
    private static char[] ch;

    public static String[] permutation(String s){
        /**
         * 字符串s里可以有重复字符，但返回的结果里不能有重复字符串
         * 设s.length = len,则结果的元素个数为len * (len - 1) * (len - 2) * ... * 2 * 1
         * 可以采用深度优先和剪枝法，需要用到递归（头疼
         * 剪枝法的实现：在dfs过程中设置HashSet，如果contain已有元素则剪枝
         *
         * 时间复杂度：O(n!)
         * 空间复杂度：O(n^2)
         */
        int len = s.length();
        if (len == 0)
            return new String[0];
        ch = s.toCharArray();
        dfs(0);
        //记住这种List -> String[]的写法！
        return list.toArray(new String[list.size()]);
    }

    public static void dfs(int index){
        if (ch.length - 1 == index){
            //字符数组转字符串 char[] -> String ，重要！！
            list.add(String.valueOf(ch));
            return;
        }
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = index; i < ch.length; i++){
            if (hashSet.contains(ch[i]))
                continue;
            hashSet.add(ch[i]);
            exchange(i, index);
            dfs(index + 1);
            exchange(i, index);
        }
    }

    public static void exchange(int index1, int index2){
        char temp = ch[index1];
        ch[index1] = ch[index2];
        ch[index2] = temp;
        return;
    }

    public static void main(String[] args) {
        String str = "abc";
        String[] res = permutation(str);
        for (String s : res)
            System.out.println(s);
    }
}
