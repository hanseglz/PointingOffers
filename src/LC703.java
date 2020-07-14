import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class LC703 {
    /**
     * 703. 数据流中第 K 大的元素
     * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
     * 你的 Kth Largest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
     * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
     * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
     */
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4,5,8,2};
        KthLargest obj = new KthLargest(nums, k);
        System.out.println(obj.add(3));     //return 4
        System.out.println(obj.add(5));     //return 5
        System.out.println(obj.add(10));    //return 5
        System.out.println(obj.add(9));     //return 8
        System.out.println(obj.add(4));     //return 8
    }
}

class KthLargest{
    /**
     * 可以使用最小堆（ PriorityQueue ）来实现
     * PriorityQueue 是小堆顶的层序遍历队列
     */
    private PriorityQueue<Integer> queue;
    private int flag;

    public KthLargest(int[] nums, int k){
        flag = k;
        queue = new PriorityQueue<>();
        for (int num : nums)
            add(num);
    }

    public int add (int val){
        if (queue.size() < flag)
            queue.add(val);
        else if (val > queue.peek()){
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }

}