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

        // BFS Multi-Source
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                int currDist = curr[2];

                for(int[] dir : directions) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    int dist = currDist + 1;

                    if(dx < 0 || dy < 0 || dx >= m || dy >= n) continue;
                    if(grid[dx][dy] == -1 || grid[dx][dy] == 0) continue;

                    if(dist < grid[dx][dy]) {
                        grid[dx][dy] = dist;
                        queue.offer(new int[]{dx, dy, dist});
                    }
                }
            }
        }
    }
}