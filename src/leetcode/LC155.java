package leetcode;

import java.util.Stack;

public class LC155 {
    /**
     * 155. Min Stack
     *
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * Implement the MinStack class:
     * MinStack() initializes the stack object.
     * void push(val) pushes the element val onto the stack.
     * void pop() removes the element on the top of the stack.
     * int top() gets the top element of the stack.
     * int getMin() retrieves the minimum element in the stack.
     *
     * Input
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * Output
     * [null,null,null,null,-3,null,0,-2]
     *
     * Explanation
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin(); // return -3
     * minStack.pop();
     * minStack.top();    // return 0
     * minStack.getMin(); // return -2
     */
    public static class MinStack {
        /**
         * Same as Test30.
         * If we traverse the stack everytime we call the getMin() method,
         * the time complexity will reach O(n), and that is not acceptable for this case,
         * which we should aim for O(1).
         * The key of this question is to use space to erase time,
         * specifically, we would use a supporting stack, not for traversing the main stack,
         * but only for keeping the minimum number in the main stack on the top of the supporting stack.
         *
         * Time complexity: O(1)
         * Space complexity: O(n)
         */
        public Stack<Integer> stack = new Stack<>();
        public Stack<Integer> backup = new Stack<>();

        public MinStack(){}

        public void push(int val){
            if (stack.empty()){
                backup.push(val);
            } else if (backup.peek() >= val){
                backup.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.peek().equals(backup.peek())) //Use .equals() instead of '==' when it comes to objects!!!!!
                backup.pop();
            stack.pop();
        }

        public int top(){
            return stack.peek();
        }

        public int getMin(){
            return backup.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
