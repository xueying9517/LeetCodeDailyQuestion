/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-24
 */
public class SolutionWangCong1503 {

    public int getLastMoment(int n, int[] left, int[] right) {
        int result = 0;
        int leftLength = left.length, rightLength = right.length;
        for (int i = 0; i < leftLength; i++) {
            if (left[i] > result) {
                result = left[i];
            }
        }
        for (int i = 0; i < rightLength; i++) {
            if (n - right[i] > result) {
                result = n - right[i];
            }
        }
        return result;
    }
}
