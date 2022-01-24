package Graph;

import java.util.Deque;
import java.util.LinkedList;

public class lc286 {
    // Multi source BFS
    public void wallsAndGates(int[][] rooms) {
        int dis = 1;
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    deque.addLast(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (deque.size() != 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] index = deque.pollFirst();
                for (int[] direction : directions) {
                    int x = index[0] + direction[0];
                    int y = index[1] + direction[1];
                    if (x >= 0 && y >= 0 && x < rooms.length && y < rooms[0].length &&
                            rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = dis;
                        deque.addLast(new int[]{x, y});
                    }
                }
            }
            dis += 1;
        }
        return;
    }
}
