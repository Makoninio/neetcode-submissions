class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> chest = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    chest.add(new int[] {i, j});
                }
            }
        }

        // Edge case
        if (chest.size() == 0) return;

        // 4 possible directions that we can go in
        int[][] dirs = { {-1,0}, {0,1}, {0, -1}, {1,0} };

        while (!chest.isEmpty()) {
            int[] node = chest.poll(); //pops first & removes it from queue
            int row = node[0];
            int col = node[1];
            // navigation in all directions
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                // checks out of bounds condition, and that it is not a wall
                if (r>=m || c>=n || r<0 || c<0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                chest.add(new int[] {r,c});

                //updates grid with distance
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
