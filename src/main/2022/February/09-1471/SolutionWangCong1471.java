import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-02-09
 */
public class SolutionWangCong1471 {

    public int[] getStrongest(int[] arr, int k) {

        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        PriorityQueue<int[]> queue = new PriorityQueue<>((array1, array2) -> {
            int o1 = Math.abs(array1[0]);
            int o2 = Math.abs(array2[0]);
            return o1 == o2 ? array2[1] - array1[1] : o2 - o1;
        } );
        int middleNum = arr[(arr.length - 1)/2];
        int length = arr.length;
        for(int i = 0; i < length; i++) {
            queue.offer(new int[]{arr[i] - middleNum, arr[i]});
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = queue.poll()[1];
        }
        return result;
    }
}
