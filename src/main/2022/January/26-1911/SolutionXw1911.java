class Solution {
    public long maxAlternatingSum(int[] nums) {
        //dp
        //dp1[i] 表示前i个并且以+结尾的最大和
        //dp2[i] 表示前i个并且以-结尾的最大和

        //dp1[i] = Math.max(dp1[i-1], dp2[i-1] + nums[i])
        //dp2[i] = Math.max(dp2[i-1], dp1[i-1] - nums[i])

        int n = nums.length;
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];

        dp1[0] = nums[0];
        long res = dp1[0];
        for(int i = 1;i < n;i++) {
            dp1[i] = Math.max(dp1[i-1], dp2[i-1] + nums[i]);
            dp2[i] = Math.max(dp2[i-1], dp1[i-1] - nums[i]);
            res = Math.max(res, dp1[i]);
            res = Math.max(res, dp2[i]);
        }
        return res;
    }
}