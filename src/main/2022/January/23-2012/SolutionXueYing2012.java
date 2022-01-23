import java.util.*;
public class SolutionXueYing2012 {
    public int sumOfBeauties(int[] nums) {
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        max[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1], nums[i - 1]);
        }
        Arrays.fill(min, Integer.MAX_VALUE);
        min[nums.length - 2] = nums[nums.length - 1];
        for (int i = nums.length - 3; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i + 1]);
        }
        int res = 0;
        for (int i = 1; i <= nums.length - 2; i++) {
            if (max[i] < nums[i] && nums[i] < min[i]) {
                res += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]){
                res += 1;
            }
        }
        return res;
    }
}
