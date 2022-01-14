import java.util.*;
public class SolutionXueYing1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (set.contains(sum - target)) {
                res++;
                set.clear();
                sum = 0;
                set.add(0);
            } else {
                set.add(sum);
            }
        }
        return res;
    }
}
