/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-23
 */
public class SolutionWangCong2012 {

    public int sumOfBeauties(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int result = 0;
        prefix[0] = Integer.MIN_VALUE;
        suffix[nums.length - 1] = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length - 2; i++) {
            prefix[i] = Math.max(prefix[i - 1], nums[i - 1]);
        }
        for (int i = nums.length - 2; i >= 1; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i + 1]);
        }
        for (int i = 1; i <= nums.length - 2; i++) {
            //第一种情况
            if (nums[i] > prefix[i] && nums[i] < suffix[i]) {
                result += 2;
            } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                result += 1;
            }
        }
        return result;
    }

}
