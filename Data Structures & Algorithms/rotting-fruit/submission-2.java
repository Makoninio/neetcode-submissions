class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (fresh > 0 && !queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0];
                int c = rotten[1];
                for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.add(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            
            time++;
        }
        return fresh == 0 ? time : -1;
        
    }
}
