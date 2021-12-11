package Graph;

import java.util.Deque;
import java.util.LinkedList;

public class lc542 {
    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> layerList = new LinkedList<>();
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int dis = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    layerList.addLast(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (layerList.size() > 0) {
            int size = layerList.size();
            for (int i = 0; i < size; i++) {
                int[] point = layerList.pollFirst();
                for (int[] direction : directions) {
                    int r = point[0] + direction[0];
                    int c = point[1] + direction[1];
                    if (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length) {
                        if (mat[r][c] == -1) {
                            mat[r][c] = dis;
                            layerList.addLast(new int[]{r, c});
                        }
                    }
                }
            }
            dis += 1;
        }

        return mat;
    }
}
