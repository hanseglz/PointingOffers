
public class Test05 {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
     * 0 <= s.length() <= 10000
     *
     * P.S.在 Python 和 Java 等语言中，字符串都被设计成不可变的类型，即无法直接修改字符串的某一位字符，需要新建一个字符串实现。
     * 当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
     * 和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
     * StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
     * 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
     * 然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
     *
     * P.P.S String类型的对象没有更改自身值的方法。
     * 当时用赋值语句对String类对象更改时，实质上是新建了一个String类的对象，并将新值赋给新对象，原对象（的引用）被丢弃，即被垃圾回收机制回收。
     */

    public static String replaceSpace(String s){
        /**
         * 从头遍历字符串，替换所有空格
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         * 关于String类对象通过赋值语句更改自身值的本质见上。
         */
        if (s == null)
            return s;

        int len = s.length();
        String res = new String();
        for (int i = 0; i < len; i++){
            if (!Character.isWhitespace(s.charAt(i))){
                res = res + s.charAt(i);
            } else{
                res = res + "%20";
            }
        }
        return res;
    }

    public static String replaceSpace2(String s){
        /**
         * 通过StringBuilder，从头遍历字符串，替换所有空格
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        if (s == null){
            return s;
        }

        int len = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++){
            if (Character.isWhitespace(s.charAt(i))){
                res.append("%20");
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "We are happy.";
//        System.out.println(str.length());
        System.out.println(replaceSpace2(str));
    }
}
