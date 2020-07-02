import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test31 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。 假设压入栈的所有数字均不相等。
     * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
     * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列
     *
     * 0 <= pushed.length == popped.length <= 1000
     * 0 <= pushed[i], popped[i] < 1000
     * pushed 是 popped 的排列。
     */
    public static boolean validateStackSequences(int[] pushed, int[] popped){
        /**
         * 栈的弹出序列的特点：对于pushed中某个元素之前的所有元素的排列顺序，如果这些元素在该popped中该元素的后置位出现，则排列顺序必相反
         * 举例来说，如果pushed = {1,2,3,4},那么在popped中，4之后如果出现了元素1和2,1一定在2的右侧；如果出现了1,2,3，则从左到右一定是3，2，1。
         * 根据此特点，遍历popped中的每个元素，将其后置位所有元素进行检测
         *
         * 时间复杂度：O(n^2)
         * 空间复杂度：O(n)
         */
        if (pushed == null && popped == null)
            return true;
        if (pushed.length != popped.length)
            return false;

        int len = popped.length;
        int minFlag;
        boolean check;
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < len; i++){
            hashmap.put(pushed[i], i);
        }
        for (int i = 0; i < len - 1; i++){
            check = false;
            minFlag = 0;
            for (int j = i + 1; j < len; j++){
                if (hashmap.get(popped[i]) > hashmap.get(popped[j]) && !check){
                    check = true;
                    minFlag = hashmap.get(popped[j]);
                }else if (hashmap.get(popped[i]) > hashmap.get(popped[j]) && check){
                    if (hashmap.get(popped[j]) > minFlag)
                        return false;
                    else
                        minFlag = hashmap.get(popped[j]);
                }
            }
        }
        return true;
    }

    public static boolean validateStackSequences2(int[] pushed, int[] popped){
        /**
         * 对于栈而言，如果给定pushed序列和popped序列，则一定能得到一个固定的出入栈顺序
         * 因此，我们可以还原一个栈结构，看看由题设给出的pushed和popped序列能否被还原成可实施的出入栈顺序
         * 具体做法为每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
         *
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        if (pushed == null && popped == null)
            return true;
        if (pushed.length != popped.length)
            return false;

        int len = pushed.length;
        int flag = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++){
            stack.push(pushed[i]);
            while (flag < len && !stack.isEmpty() && stack.peek() == popped[flag]){
                flag++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,0};
        int[] poped = {1,0};
        System.out.println(validateStackSequences2(pushed, poped));
    }
}
