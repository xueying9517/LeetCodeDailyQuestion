/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-26
 */
public class SolutionWangCong1911 {

    public long maxAlternatingSum(int[] nums) {

        long[] dp = new long[nums.length];
        int[] dpLastIndexs = new int[nums.length];
        dp[0] = nums[0];
        dpLastIndexs[0] = 0;

        if(nums.length == 1) {
            return dp[0];
        }

        if(nums.length == 2) {
            return Math.max(dp[0], dp[1]);
        }
        if(nums[0] > nums[1]) {
            dp[1] = nums[0];
            dpLastIndexs[1] = 0;
        } else {
            dp[1] = nums[1];
            dpLastIndexs[1] = 1;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                // if(dpLastIndexs[i-1] == i-1) {
                //     dp[i] = dp[i-1] + nums[i] - nums[i-1];
                //     dpLastIndexs[i] = i;
                // } else {
                //     dp[i] = dp[i-1] + nums[i] - nums[i-1];
                //     dpLastIndexs[i] = i;
                // }
                dp[i] = dp[i-1] + nums[i] - nums[i-1];
                dpLastIndexs[i] = i;
            } else {
                dp[i] = dp[i-1];
                dpLastIndexs[i] = dpLastIndexs[i-1];
            }
        }

        return dp[nums.length - 1];

    }
}
