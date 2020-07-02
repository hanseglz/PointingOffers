import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.remove(list.size() - 1);
        System.out.println(list);
    }
}
