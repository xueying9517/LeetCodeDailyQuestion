import java.util.*;
public class SolutionXueYing2104 {
    long res;
    List<Integer> list;
    int min;
    int max;
    public long subArrayRanges(int[] nums) {
        res = 0;
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(nums, 0, true);
        return res;
    }
    private void dfs(int[] nums, int s, boolean move) {
        if (list.size() != 0) {
            res += max - min;
        }
        int n1 = min, n2 = max;
        for (int i = s; i < nums.length; i++) {
            list.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            dfs(nums, i + 1, false);
            list.remove(list.size() - 1);
            min = n1;
            max = n2;
            if (!move) {
                return;
            }
        }
        return;
    }
}
