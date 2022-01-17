import java.util.*;

public class SolutionXueYing1591 {
    public boolean isPrintable(int[][] targetGrid) {
        List[] list = new List[61];
        int[] top = new int[61];
        int[] bottom = new int[61];
        int[] left = new int[61];
        int[] right = new int[61];
        for (int i = 1; i <= 60; i++) {
            top[i] = 61;
            bottom[i] = 0;
            left[i] = 61;
            right[i] = 0;
        }
        for (int i = 0; i < targetGrid.length; i++) {
            for (int j = 0; j < targetGrid[0].length; j++) {
                int color = targetGrid[i][j];
                top[color] = Math.min(top[color], i);
                bottom[color] = Math.max(bottom[color], i);
                left[color] = Math.min(left[color], j);
                right[color] = Math.max(right[color], j);
            }
        }
        boolean[][] mark = new boolean[61][61];
        int[] inDegree = new int[61];
        for (int i = 1; i <= 60; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < targetGrid.length; i++) {
            for (int j = 0; j < targetGrid[0].length; j++) {
                int color = targetGrid[i][j];
                for (int m = 1; m <= 60; m++) {
                    if (top[m] <= i && bottom[m] >= i && left[m] <= j && right[m] >= j &&
                            color != m && !mark[color][m]) {
                        list[color].add(m);
                        mark[color][m] = true;
                        inDegree[m]++;
                    }
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 60; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                int tmp = (Integer) list[cur].get(i);
                inDegree[tmp]--;
                if (inDegree[tmp] == 0) {
                    queue.offer(tmp);
                }
            }
        }
        for (int i = 1; i <= 60; i++) {
            if (inDegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
