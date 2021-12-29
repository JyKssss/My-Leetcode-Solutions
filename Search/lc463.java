package Search;

public class lc463 {
    int perimeter = 0;
    public int islandPerimeter(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    searchLand(visited, grid, i, j, grid.length, grid[0].length);
                    break;
                }
            }
        }
        return perimeter;
    }

    private void searchLand(boolean[][] visited, int[][] grid, int r, int c, int R, int C) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return;
        }
        visited[r][c] = true;
        if (r - 1 < 0 || grid[r - 1][c] == 0) {
            perimeter += 1;
        } else {
            if (!visited[r - 1][c]) {
                searchLand(visited, grid, r - 1, c, R, C);
            }
        }

        if (c - 1 < 0 || grid[r][c - 1] == 0) {
            perimeter += 1;
        } else {
            if (!visited[r][c - 1]) {
                searchLand(visited, grid, r - 1, c, R, C);
            }
        }

        if (r + 1 >= R || grid[r + 1][c] == 0) {
            perimeter += 1;
        } else {
            if (!visited[r + 1][c]) {
                searchLand(visited, grid, r + 1, c, R, C);
            }
        }

        if (c + 1 >= C || grid[r][c + 1] == 0) {
            perimeter += 1;
        } else {
            if (!visited[r][c + 1]) {
                searchLand(visited, grid, r, c + 1, R, C);
            }
        }
    }

    public int islandPerimeter2(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i -1][j] == 0){
                        perimeter += 1;
                    }
                    if (j == 0 || grid[i][j - 1] == 0){
                        perimeter += 1;
                    }

                    if (i == grid.length -1 || grid[i + 1][j] == 0){
                        perimeter += 1;
                    }
                    if (j == grid[0].length -1 || grid[i][j + 1] == 0){
                        perimeter += 1;
                    }
                }
            }
        }
        return perimeter;
    }
}
