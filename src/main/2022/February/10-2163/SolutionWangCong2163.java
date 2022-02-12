import java.util.PriorityQueue;

/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-02-12
 */
public class SolutionWangCong2163 {

    public long minimumDifference(int[] nums) {

        int unitLength = nums.length / 3;
        //求最小值，大根堆
        PriorityQueue<Integer> firstNQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        PriorityQueue<Integer> firstNQueue = new PriorityQueue<>(Comparator.reverseOrder());

        //求最大值,小根堆
        PriorityQueue<Integer> lastNQueue = new PriorityQueue<>();

        /**
         firstSumArray[i] 表示数组nums中 0 到 unitLength + i 元素的最小值，
         lastSumArray[i] 表示数组nums中 unitLength + i + 1到 nums.length -1的最大值
         */
        long[] firstSumArray = new long[unitLength + 1];
        long[] lastSumArray = new long[unitLength + 1];

        long currentSum = 0;
        for (int i = 0; i < unitLength; i++) {
            firstNQueue.offer(nums[i]);
            currentSum += nums[i];
        }
        firstSumArray[0] = currentSum;
        //大根堆
        for (int i = unitLength ; i <= 2 * unitLength -1; i++) {
            int peekValue = firstNQueue.peek();
            if (nums[i] < peekValue) {
                currentSum = currentSum - peekValue + nums[i];
                firstNQueue.poll();
                firstNQueue.offer(nums[i]);
            }
            firstSumArray[i - unitLength +1 ] = currentSum;
        }


        currentSum = 0;
        for (int i = 3 * unitLength - 1; i >= 2 * unitLength; i--) {
            lastNQueue.offer(nums[i]);
            currentSum += nums[i];
        }
        // lastSumArray
        lastSumArray[unitLength] = currentSum;

        //小根堆
        for (int i = 2 * unitLength - 1; i >= unitLength; i--) {
            int peekValue = lastNQueue.peek();
            if (nums[i] > peekValue) {
                currentSum = currentSum - peekValue + nums[i];
                lastNQueue.poll();
                lastNQueue.offer(nums[i]);
            }
            lastSumArray[  i - unitLength ] = currentSum;
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i < unitLength + 1; i++) {
            // System.out.println("i="+i +", firstSumArray[i]="+ firstSumArray[i]
            // +", lastSumArray[i]="+lastSumArray[i]);
            long temp = firstSumArray[i] - lastSumArray[i];
            if (temp < result) {
                result = temp;
            }
        }
        return result;
    }
}
