import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        /**
         * 不推荐使用add()和remove()方法，因为失败时会抛出异常
         * 推荐使用offer()替代add()，poll()替代remove()
         * 可以使用peek()方法，也可以使用element()方法，效果相同（返回队首元素）
         */
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.offer(4);
        for (int element : queue){
            System.out.println(element);
        }
        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.element());
    }
}
