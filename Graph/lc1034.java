package Graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        List<Pair<Integer, Integer>> borderList = new ArrayList<>();
        HashSet<Pair<Integer, Integer>> connectedSet = new HashSet<>();
        int ogColor = grid[row][col];
        dfs(connectedSet, grid, row, col);
        for (Pair<Integer, Integer> node : connectedSet) {
            if (verifyBorder(node, grid)) {
                borderList.add(node);
            }
        }
        for (Pair<Integer, Integer> border : borderList) {
            grid[border.getKey()][border.getValue()] = color;
        }
        return grid;
    }

    private boolean verifyBorder(Pair<Integer, Integer> node, int[][] grid) {
        int r = node.getKey(), c = node.getValue();
        if (r == 0 || c == 0
                || r == grid.length - 1 || c == grid[0].length - 1) {
            return true;
        }
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] direction : directions) {
            int row = r + direction[0], col = c + direction[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                if (grid[row][col] != grid[r][c]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(HashSet<Pair<Integer, Integer>> connectedSet, int[][] grid, int row, int col) {
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int color = grid[row][col];
        connectedSet.add(new Pair<>(row, col));
        for (int[] direction : directions) {
            int r = row + direction[0], c = col + direction[1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                if (grid[r][c] == color && !connectedSet.contains(new Pair<>(r, c))) {
                    dfs(connectedSet, grid, r, c);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1}, {1, 2}};
        lc1034 obj = new lc1034();
        System.out.println(Arrays.deepToString(obj.colorBorder(grid, 0, 0, 3)));
    }
}
