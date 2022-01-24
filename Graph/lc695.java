package Graph;

public class lc695 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visitedGrid = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visitedGrid[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, visitedGrid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visitedGrid, int x, int y) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        visitedGrid[x][y] = true;
        int square = 1;
        for (int[] direction : directions) {
            int x1 = x + direction[0];
            int y1 = y + direction[1];
            if (x1 >= 0 && x1 < grid.length && y1 > 0 && y1 < grid[0].length &&
                grid[x1][y1] == 1 && !visitedGrid[x1][y1]) {
                square += dfs(grid, visitedGrid, x1, y1);
            }
        }
        return square;
    }
}
