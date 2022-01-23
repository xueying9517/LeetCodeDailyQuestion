class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        leftMax[0] = nums[0];
        for(int i = 1;i < n;i++) {
            leftMax[i] = Math.max(leftMax[i-1], nums[i]);
        }
        rightMin[n-1] = nums[n-1];
        for(int i = n - 2;i >= 0;i--) {
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        }

        int res = 0;
        for(int i = 1;i <= n - 2;i++) {
            int lMax = leftMax[i-1];
            int rMin = rightMin[i+1];
            int add = 0;
            if(nums[i] > lMax && nums[i] < rMin) {
                add = 2;
            } else if(nums[i] > nums[i-1] && nums[i] < nums[i+1]) {
                add = 1;
            } else {
                
            }
            res += add;
            System.out.println(add);
        }
        return res;
    }
}