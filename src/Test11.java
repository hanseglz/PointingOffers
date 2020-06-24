
public class Test11 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
     */
    public static int minArray(int[] numbers){
        /**
         * 暴力算法，直接遍历，数组前值大于后值时，后值即为所求
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         */
        int len = numbers.length;
        int res = numbers[0];

        //这种情况不仅考虑了旋转数组首尾相等，即数组元素全部相同的情况，同时也考虑了数组长为1的情况
        //↑↑↑错误！！！！！！！！ 首尾相等不一定意味着数组元素全部相同，比如{3,1,3}
//        if (numbers[0] == numbers[len - 1]){
//            res = numbers[0];
//        }

        for (int i = 0; i < len-1; i++){
            if (numbers[i] > numbers[i+1]){
                res = numbers[i+1];
            }
        }
        return res;
    }

    public static int minArray2(int[] numbers){
        /**
         * 排序数组的查找问题首先考虑使用 二分法 解决，其可将遍历法的线性级别时间复杂度降低至对数级别
         * 首先设置首尾指针，不停地取中间处所指向的数值
         * 由于数组被分为了左右两部分，两部分均为递增，且左数组所有元素均大于右数组
         * 所以当中间值大于尾指针值时取右半部分，当中间值小于尾指针时取左半部分,如果等于则都有可能(33313,31333)
         * 当中间值 = 尾值的情况发生时，令尾指针向前指一位，缩小范围
         * 时间复杂度：O(logn)
         */
        int len = numbers.length;
        if (len == 1){
            return numbers[0];
        }

        int head = 0, tail = len - 1;
        while (head < tail - 1){
            int middle = (head + tail) / 2;
            if (numbers[middle] > numbers[tail]){
                head = middle;
                continue;
            }
            else if (numbers[middle] < numbers[tail]){
                tail = middle;
            }
            else{
                tail--;
            }
        }
        return Math.min(numbers[head], numbers[tail]);
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,3,1};
        System.out.println(minArray2(arr));
    }
}
