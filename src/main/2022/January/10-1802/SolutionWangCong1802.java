public class SolutionWangCong1802 {
    public int maxValue(int n, int index, int maxSum) {

        /**
         单个循环会超时,需要分几种情况考虑
         */
        int rightIndexNum =  n - index - 1;
        int maxBoundary = Math.max(index, rightIndexNum);
        int minBoundary = Math.min(index, rightIndexNum);

        long limit1 = ((long)minBoundary + 1) * ((long)minBoundary + 1) + maxBoundary - minBoundary ;
        long limit2 = ((long)maxBoundary + 2) * ((long)maxBoundary +1) /2
                + ( maxBoundary * 2 - minBoundary +1) * minBoundary /2;

        if((long)maxSum <= limit1) {
            int sum = maxSum - n;
            int i  = 0;
            for(; sum >= 0; i++) {
                sum -=  (i * 2 + 1);
            }
            return i;
        } else if((long)maxSum <= limit2) {
            int sum = (int)(maxSum - limit1 - ( 2 * minBoundary +1));
            int i = minBoundary + 1;
            for(; sum >= 0; i++) {
                // System.out.print("sum="+ sum + ",i="+i);
                sum -= (i + minBoundary + 1);
            }
            return i;
        } else {
            int sum = (int)(maxSum - limit2);
            // System.out.println("sum2="+ sum + ",n="+n);
            return maxBoundary + 1 + sum/n;
        }
    }
}
