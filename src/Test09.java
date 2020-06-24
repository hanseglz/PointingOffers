import java.util.Stack;

public class Test09 {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
     * 若队列中没有元素，deleteHead 操作返回 -1。
     * 1 <= values <= 10000
     * 最多会对 appendTail、deleteHead 进行 10000 次调用
     */

    public static class CQueue{
        private Stack<Integer> stack1 = new Stack<Integer>();
        private Stack<Integer> stack2 = new Stack<Integer>();

        public CQueue(){
            System.out.println("null");
        }

        public void appendTail(int value){
            System.out.println("null");
            stack1.push(value);
        }

        public int deleteHead(){
            if (stack1.isEmpty()){
                System.out.println(-1);
                return -1;
            }else{
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                int res = stack2.pop();
                while (!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
                System.out.println(res);
                return res;
            }
        }
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.deleteHead();
        queue.appendTail(5);
        queue.appendTail(2);
        queue.deleteHead();
        queue.deleteHead();
    }
}
