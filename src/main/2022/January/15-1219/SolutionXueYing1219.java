public class SolutionXueYing1219 {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j, 0));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int i, int j, int num) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return num;
        }
        int tmp = grid[i][j];
        grid[i][j] = 0;
        int a = dfs(grid, i - 1, j, num + tmp);
        int b = dfs(grid, i, j - 1, num + tmp);
        int c = dfs(grid, i + 1, j, num + tmp);
        int d = dfs(grid, i, j + 1, num + tmp);
        grid[i][j] = tmp;
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
}
