import java.util.Arrays;

/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-27
 */
public class SolutionWangCong1921 {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int length = dist.length;
        double[] reachTime = new double[length];
        for(int i = 0; i < length ; i++) {
            reachTime[i] = (double)dist[i] / speed[i];
        }
        Arrays.sort(reachTime);
        // System.out.println(Arrays.toString(reachTime));
        for(int i = 1; i < length; i++) {
            if(reachTime[i] <= i) {
                return i ;
            }
        }
        return length;

    }
}
