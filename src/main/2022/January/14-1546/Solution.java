class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int presum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        
        sumMap.put(0, 1);
        
        int res = 0;
        for(int i = 0;i < nums.length;i++) {
            presum += nums[i];
            
            int fKey = presum - target;
            if(sumMap.containsKey(fKey)) {
                res++;
                sumMap.clear();
                sumMap.put(0, 1);
                presum = 0;
            } else {
                sumMap.put(presum, sumMap.getOrDefault(presum, 0) + 1);
            }
        }
        
        return res;
    }
}