class Solution {

    private int[][] directions = {
        {0, 1}, // right
        {0, -1}, // left
        {1, 0}, // bottom
        {-1, 0} // top
    };

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // Multi-Source
                if(grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] source = queue.poll();
            int r = source[0];
            int c = source[1];

            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                if(grid[nr][nc] != Integer.MAX_VALUE) continue;

                grid[nr][nc] = grid[r][c] + 1;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}