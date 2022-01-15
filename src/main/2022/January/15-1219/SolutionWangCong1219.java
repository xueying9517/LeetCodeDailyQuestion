/**
 * @author wangcong03 <wangcong03@kuaishou.com>
 * Created on 2022-01-15
 */
public class SolutionWangCong1219 {

    boolean[][] mark;
    int max = 0;

    public int getMaximumGold(int[][] grid) {
        mark = new boolean[grid.length][grid[0].length];
        int M = grid.length, N = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    helper(grid, i, j, M, N, 0);
                }
            }
        }
        return max;
    }

    public void helper(int[][] grid, int i, int j, int M, int N, int sum) {

        if (i < 0 || i >= M || j < 0 || j >= N || mark[i][j] == true
                || grid[i][j] == 0) {
            if (sum > max) {
                max = sum;
            }
            return;
        }
        mark[i][j] = true;
        sum = sum + grid[i][j];
        helper(grid, i - 1, j, M, N, sum);
        helper(grid, i + 1, j, M, N, sum);
        helper(grid, i, j - 1, M, N, sum);
        helper(grid, i, j + 1, M, N, sum);
        mark[i][j] = false;
    }
}
