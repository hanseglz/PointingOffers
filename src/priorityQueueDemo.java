import java.util.PriorityQueue;

public class priorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(5);
        queue.add(8);
        queue.add(2);
//        queue.add(9);
//        queue.add(15);
//        queue.add(11);
//        queue.add(13);
//        queue.add(20);
//        queue.add(12);
        System.out.println(queue.size());
        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }
}
