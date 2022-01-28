import java.util.Arrays;
import java.util.Comparator;

/**
 * @author XueYing <wangcong03@kuaishou.com>
 * Created on 2022-01-28
 */
public class SolutionXueYing1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < properties.length; i++) {
            if (max > properties[i][1]) {
                res++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return res;
    }
}

