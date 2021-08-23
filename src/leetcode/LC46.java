package leetcode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46 {
    /**
     * 46. Permutations
     *
     * Given an array nums of distinct integers,
     * return all the possible permutations. You can return the answer in any order.
     *
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    public static LinkedList<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1){
            List<Integer> list = new LinkedList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }

        for (int num : nums){
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(num);
            res.add(temp);
        }
        while (res.peek().size() < nums.length){
            List<Integer> list = res.remove();
            for (int num : nums){
                if (!list.contains(num)){
                    list.add(num);
                    List<Integer> temp = new LinkedList<>(list);
                    res.add(temp);
                    list.remove(list.size()-1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }
}
