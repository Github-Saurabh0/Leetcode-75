class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queueint[] queue = new LinkedList();

         Step 1 Initialize
        for (int i = 0; i  m; ++i) {
            for (int j = 0; j  n; ++j) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});   BFS starting points
                } else {
                    dist[i][j] = Integer.MAX_VALUE;   1s ke liye initially infinite
                }
            }
        }

         Step 2 BFS traversal
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};   4 directions
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir  directions) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX = 0 && newY = 0 && newX  m && newY  n &&
                    dist[newX][newY]  dist[x][y] + 1) {
                    dist[newX][newY] = dist[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return dist;
    }
}
