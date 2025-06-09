class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, time = 0;

        // Step 1: Find all rotten oranges and count fresh
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Step 2: BFS to rot adjacent oranges
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] d : directions) {
                    int r = cell[0] + d[0], c = cell[1] + d[1];
                    if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
