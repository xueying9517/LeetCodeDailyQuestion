public class SolutionXueYing2163 {
    public long minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m / 3;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        long res = Long.MAX_VALUE;
        long preSum = 0;
        long sufSum = 0;
        long[] sufSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pq1.offer(nums[i]);
            preSum += nums[i];
            int j = m - i - 1;
            sufSum += nums[j];
            pq2.offer(nums[j]);
        }
        sufSumArr[n] = sufSum;
        for (int i = 2 * n - 1; i >= n; i--) {
            pq2.offer(nums[i]);
            sufSum += nums[i] - pq2.poll();
            sufSumArr[i - n] = sufSum;
        }
        res = preSum - sufSumArr[0];
        for (int i = n; i < 2 * n; i++) {
            pq1.offer(nums[i]);
            preSum += nums[i] - pq1.poll();
            res = Math.min(res, preSum - sufSumArr[i - n + 1]);
        }
        return res;
    }
}
