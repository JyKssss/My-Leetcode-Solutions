package Graph;

import java.util.Deque;
import java.util.LinkedList;

public class lc934 {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Deque<int[]> deque = new LinkedList<>();
    public int shortestBridge(int[][] grid) {
        boolean isFind = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isFind) break;
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    isFind = true;
                    break;
                }
            }
        }

        int disance = 0;
        while (deque.size() > 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] index = deque.pollFirst();
                for (int[] direction : directions) {
                    int x1 = index[0] + direction[0];
                    int y1 = index[1] + direction[1];
                    if (x1 >=0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length) {
                        if (grid[x1][y1] == 0) {
                            grid[x1][y1] = 2;
                            deque.addLast(new int[]{x1, y1});
                        } else if (grid[x1][y1] == 1) {
                            return disance;
                        }
                    }
                }
            }
            disance += 1;
        }
        return disance;
    }

    private void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        deque.addLast(new int[]{x, y});
        for (int[] direction : directions) {
            int x1 = x + direction[0];
            int y1 = y + direction[1];
            if (x1 >=0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == 1) {
                dfs(grid, x1, y1);
            }
        }
    }

    public static void main(String[] args) {
        lc934 obj = new lc934();
        System.out.println(obj.shortestBridge(new int[][]{{0, 1},{1, 0}}));
    }
}
