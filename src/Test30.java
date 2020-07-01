import java.util.Stack;

public class Test30 {
    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     * 各函数的调用总次数不超过 20000 次
     */
    public static class MinStack{
        /**
         * 本题难点在于最后的min方法，如果简单的采取将原栈中的所有数遍历一遍寻找最小值的方法，时间复杂度将达到O(n)
         * 而我们的目标是将min方法的时间复杂度降低到题目要求的O(1)
         * 具体思路为利用辅助栈
         * 当主栈push新数时，判断新数是否小于辅助栈栈顶，若是则同样将新数push进辅助栈，使得辅助栈栈顶一直是所有数中的最小值
         * 当主栈pop时，相应的判断一下辅助栈需不需要同时pop
         */
        Stack<Integer> stack1, stack2;

        public MinStack(){
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x){
            if (stack2.isEmpty()){
                stack1.push(x);
                stack2.push(x);
            }
            //这里必须写成 >= 的形式，否则后面写pop方法时
            //不能直接判断是否pop辅助栈，例如当push顺序为010时,stack1 = 010, stack2 = 0
            else if (stack2.peek() >= x){
                stack1.push(x);
                stack2.push(x);
            }else
                stack1.push(x);
        }

        public void pop(){
            /*if (stack1.peek() == stack2.peek())
                stack2.pop();
            stack1.pop();*/
            // 如果是↑的写法是不行的，这里只能用.equals，不能用==
            // 具体原因是因为因为==在比较基本数据类型的时候才是比较内容大小，Integer不是基本数据类型，
            // ==比较的是引用的对象地址，equals在没有重写的时候功能和==一样，重写之后就是比较内容大小，
            // Integer对象已经重写了equals，所以是比较内容，所以要比较Integer内容不能用==，必须用重写之后的equals
            if (stack1.pop().equals(stack2.peek()))
                stack2.pop();
        }

        public int top(){
            return stack1.peek();
        }

        public int min(){
            return stack2.peek();
        }
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
    }
}
