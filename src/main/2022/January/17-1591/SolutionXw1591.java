class Solution {
    int[] h;
    int[] e;
    int[] ne;
    int idx;

    public void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public boolean isPrintable(int[][] targetGrid) {
        int row = targetGrid.length;
        int column = targetGrid[0].length;

        int[] top = new int[61];
        int[] left = new int[61];
        int[] right = new int[61];
        int[] bottom = new int[61];

        for(int i = 0;i < 61;i++) {
            top[i] = Integer.MAX_VALUE;
            left[i] = Integer.MAX_VALUE;
            bottom[i] = Integer.MIN_VALUE;
            right[i] = Integer.MIN_VALUE;
        }

        for(int i = 0;i < row;i++) {
            for(int j = 0;j < column;j++) {
                int currentColor = targetGrid[i][j];
                top[currentColor] = Math.min(top[currentColor], i);
                bottom[currentColor] = Math.max(bottom[currentColor], i);
                left[currentColor] = Math.min(left[currentColor], j);
                right[currentColor] = Math.max(right[currentColor], j);
            }
        }

        h = new int[61];
        for(int i = 0;i < 61;i++) h[i] = -1;
        e = new int[10010];
        ne = new int[10010];
        idx = 0;

        int[] degree = new int[61];
        boolean[][] isConnect = new boolean[61][61];

        for(int i = 0;i < row;i++) {
            for(int j = 0;j < column;j++) {
                int currentColor = targetGrid[i][j];
                for(int c = 1;c < 61;c++) {
                    if(top[c] <= i && bottom[c] >= i && left[c] <= j && right[c] >= j && c != currentColor) {
                        if(!isConnect[c][currentColor]) {
                            isConnect[c][currentColor] = true;
                            add(c, currentColor);
                            degree[currentColor]++;
                        }
                    }
                }
            }
        }

        List<Integer> topo = new ArrayList<>();
        while(true) {
            boolean deleteNode = false;
            for(int i = 1;i < 61;i++) {
                if(degree[i] == 0) {
                    deleteNode = true;
                    topo.add(i);
                    degree[i] = -1;
                    for(int j = h[i];j != -1;j = ne[j]) {
                        degree[e[j]]--;
                    }
                }
            }
            if(!deleteNode) break;
        }
        return topo.size() == 60;
    }
}