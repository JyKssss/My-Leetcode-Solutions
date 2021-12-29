package Search;

import java.util.Deque;
import java.util.LinkedList;

public class lc1197 {
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return  0;
        }
        int disBar = 10, total = 0;
        int minDis;
        x = Math.abs(x) + disBar;
        y = Math.abs(y) + disBar;
        int[][] visitedGraph = new int[Math.max(2 * x, 20)][Math.max(2 * y, 20)];
        int[][] directions = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
        Deque<int[]> layer = new LinkedList<>();
        layer.addLast(new int[]{disBar,disBar});
        visitedGraph[disBar][disBar] = 1;
        minDis = hDis(x, y, disBar, disBar);
        while (layer.size() > 0) {
            int size = layer.size();
            for (int i = 0; i < size; i++) {
                int[] node = layer.pollFirst();
                for (int[] direction : directions) {
                    int nX = node[0] + direction[0];
                    int nY = node[1] + direction[1];
                    if (nX >= 0 && nY >= 0 && nX < visitedGraph.length && nY <visitedGraph[0].length ) {
                        if (visitedGraph[nX][nY] == 0) {
                            visitedGraph[nX][nY] = 1;
                            int curDis = hDis(x, y, nX, nY);
                            if (curDis <= minDis || curDis <= disBar) {
                                minDis = Math.min(minDis, curDis);
                                layer.addLast(new int[]{nX, nY});
                            }
                        }
                    }
                }
            }
            total += 1;
            if (visitedGraph[x][y] == 1){
                break;
            }
        }
        return total;
    }

    private int hDis(int x, int y, int x1, int y1) {
        return Math.abs(x1 - x) + Math.abs(y1 - y);
    }
}
