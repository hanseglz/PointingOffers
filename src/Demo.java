import java.util.Arrays;
import java.util.Stack;

public class Demo {

    public static class Testing{
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        public void push(int x){
            stack3.push(x);
            stack4.push(x);
        }

        public boolean judgeSame(){
            if (stack3.peek() == stack4.peek())
                return true;
            else
                return false;
        }

        public boolean judgeEqual(){
            if (stack3.peek().equals(stack4.peek()))
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(1);
        stack2.push(1);
        System.out.println(stack1.peek() == stack2.peek());
        System.out.println(stack1.peek().equals(stack2.peek()));

        Testing obj = new Testing();
        obj.push(1);
        System.out.println(obj.judgeSame());
        System.out.println(obj.judgeEqual());
    }
}
