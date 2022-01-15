class SolutionXiaoWei1219 {
    int r;
    int c;
    public int getMaximumGold(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int res = 0;
        
        for(int i = 0;i < r;i++) {
            for(int j = 0;j < c;j++) {
                if(grid[i][j] > 0) {
                    res = Math.max(dfs(grid, i, j), res);
                }
            }
        }
        
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j) {
        int cur = grid[i][j];
        grid[i][j] = 0;
        int[][] dirs = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        
        int nextMax = 0;
        for(int[] dir : dirs) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if(ii >= 0 && ii < r && jj >= 0 && jj < c && grid[ii][jj] > 0) {
                nextMax = Math.max(nextMax, dfs(grid, ii, jj));
            }
        }
        grid[i][j] = cur;
        return cur + nextMax;
    }
}