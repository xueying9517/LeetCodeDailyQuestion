class Solution {
    public long subArrayRanges(int[] nums) {
        long max_sum = 0, min_sum = 0;
        for(int i = 0;i < nums.length;i++) {
            int max = nums[i];
            int min = nums[i];
            for(int j = i;j < nums.length;j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                max_sum += max;
                min_sum += min;
            }
        }
        return max_sum - min_sum;
    }
}