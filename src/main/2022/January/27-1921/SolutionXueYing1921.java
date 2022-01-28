import java.util.PriorityQueue;

/**
 * @author xueying <wangcong03@kuaishou.com>
 * Created on 2022-01-28
 */
public class SolutionXueYing1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            queue.offer((int)Math.ceil((double)dist[i] / (double)speed[i]));
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur <= res) {
                return res;
            }
            res++;
        }
        return dist.length;
    }
}
