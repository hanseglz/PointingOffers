import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 3)
            return res;

        int target, m = len - 1;
        for (int i = 0; i < m - 1; i++){
            m = len - 1;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            target = -nums[i];
            for (int j = i + 1; j < m; j++){
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                while (j < m && nums[j] + nums[m] > target)
                    m--;
                if (j == m){
                    m = len - 1;
                    continue;
                }
                if (nums[j] + nums[m] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[m]);
                    res.add(list);
                    m = len - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.deepToString(threeSum(nums).toArray()));
    }
}
