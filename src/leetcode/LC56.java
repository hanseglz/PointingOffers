package leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    /**
     * 56. Merge Intervals
     *
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
     * and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        mySort(intervals);
        int[][] res = new int[intervals.length][2];
        int index = 0;
        for (int i = 1; i < intervals.length; i++){
            int[] arr1 = intervals[i-1];
            int[] arr2 = intervals[i];
            if (arr1[1] < arr2[0]){
                res[index++] = arr1;
            } else if (arr1[1] >= arr2[1]){
                arr2[0] = arr1[0];
                arr2[1] = arr1[1];
            } else {
                arr2[0] = arr1[0];
            }
        }
        res[index++] = intervals[intervals.length-1];

        int[][] ans = new int[index][2];
        for (int i = 0; i < index; i++)
            ans[i] = res[i];
        return ans;
    }

    public static int[][] mySort(int[][] array){
        // 新建一个比较器Comparator作为匿名内部类
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    // 若俩数组的第一个元素相等，则比较它们的第二个元素
                    return o1[1] - o2[1];
                }else {
                    // 若俩数组的第一个元素不相等，则按从小到大的顺序排列
                    return o1[0] - o2[0];
                }
            }
        });
        return array;
    }

    public static void main(String[] args) {
        int[][] arrs = {
                {1,4},{5,6},{2,3}
        };
        int[][] res = merge(arrs);
        for (int[] arr : res)
            System.out.println(Arrays.toString(arr));
    }
}
