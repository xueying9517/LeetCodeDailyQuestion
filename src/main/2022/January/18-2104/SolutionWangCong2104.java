/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-18
 */
public class SolutionWangCong2104 {

    long sum = 0;

    public long subArrayRange(int[] nums) {
        if (nums.length == 0) {
            return 0L;
        }
        for (int i = 0; i < nums.length; i++) {
            visit(nums, i+1, nums[i], nums[i], i, i);
        }
        return sum;
    }

    public void visit(int[] nums, int i, int min, int max, int begin, int end) {
        if (i == nums.length) {
//            String tmp3 = "i=" + i + ",begin=" + begin + ",end=" + end + ",max=" + max + ",min=" + min;
//            System.out.println(tmp3);
            sum += (max - min);
            return;
        }
        int value = nums[i];
        int newMin = value < min ? value : min;
        int newMax = value > max ? value : max;
        //包含i的场景
        visit(nums, i + 1, newMin, newMax, begin, i);

        //不包含i的场景
        sum += (max - min);
//        String tmp = "i=" + i + ",begin=" + begin + ",end=" + end + ",max=" + max + ",min=" + min;
//        System.out.println(tmp);
    }

    public static void main(String[] args) {
        SolutionWangCong2104 solutionWangCong2104 = new SolutionWangCong2104();
        int[] nums = new int[]{4, -2, -3, 4, 1};
        long result = solutionWangCong2104.subArrayRange(nums);
        System.out.println("result=" + result);
//        solutionWangCong2104.visit(nums, 4, 4, -3, 0 , 3);

    }
}
