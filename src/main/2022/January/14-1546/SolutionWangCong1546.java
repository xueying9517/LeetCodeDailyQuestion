import java.util.HashSet;
import java.util.Set;

/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-17
 */
public class SolutionWangCong1546 {

    public int maxNonOverlapping(int[] nums, int target) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(0);
            int sum = 0;
            while (i < length) {
                sum += nums[i];
                if(set.contains(sum - target)) {
                    res++;
                    break;
                } else {
                    set.add(sum);
                    i++;
                }
            }
        }
        return res;
    }

    public int maxNonOverlappingOld(int[] nums, int target) {
        int result = 0;
        int start = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = start; j < nums.length && sum <= target; j++) {
                sum += nums[j];
                if (sum == target) {
                    System.out.println("start=" + start + ",j=" + j);
                    start = j + 1;
                    result++;
                    break;
                }
                if (sum == 0) {
                    start++;
                    break;
                }
                if (sum > target) {
                    start++;
                    break;
                }
            }
            sum = 0;
        }
        return result;
    }



    public static void main(String[] args) {
        SolutionWangCong1546 solution = new SolutionWangCong1546();
        int result = solution.maxNonOverlapping(new int[]{-1, -2, 8, -3, 8, -5, 5, -4, 2, 3, 4, 1}, 5);
        System.out.println(result);
    }
}
