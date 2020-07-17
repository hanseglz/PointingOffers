import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test41 {
    /**
     * 如何得到一个数据流中的中位数？
     * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
     * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     *
     * 例如，
     * [2,3,4] 的中位数是 3
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     *
     * 设计一个支持以下两种操作的数据结构：
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     */
    /**
     * 注意，本题实际的输入顺序和数的大小无关，而最后结果要求的是所有输入中的中位数
     * 可以采用大小根堆的方法实现
     * @param args
     */
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedium());
        obj.addNum(3);
        System.out.println(obj.findMedium());
        obj.addNum(2);
        System.out.println(obj.findMedium());
    }
}

class MedianFinder{

    private Queue<Integer> queue1, queue2;

    public MedianFinder(){
        queue1 = new PriorityQueue<>();                      //小顶堆
        queue2 = new PriorityQueue<>((x, y) -> (y - x));     //大顶堆
    }

    public void addNum(int num){
        if (queue1.size() != queue2.size()){
            queue1.add(num);
            queue2.add(queue1.poll());
        }else{
            queue2.add(num);
            queue1.add(queue2.poll());
        }
    }

    public double findMedium(){
        return queue1.size() != queue2.size() ? queue1.peek() : (queue1.peek() + queue2.peek()) / 2.0;
    }
}