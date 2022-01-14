package Graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class lc1036 {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (source[0] == target[0] && source[1] == target[1]) {
            return true;
        }
        int maxIndex = 1000000 - 1;
        int[][] directions = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
        HashSet<String> visitedSetSource = new HashSet<>();
        HashSet<String> visitedSetTarget = new HashSet<>();
        HashSet<String> blockedSet = new HashSet<>();
        Deque<int[]> sourceList = new LinkedList<>();
        Deque<int[]> targetList = new LinkedList<>();
        for (int[] b : blocked) {
            blockedSet.add(b[0] + "_" + b[1]);
        }
        sourceList.addLast(source);
        targetList.addLast(target);
        visitedSetSource.add(source[0] + "_" + source[1]);
        visitedSetTarget.add(target[0] + "_" + target[1]);

        while (sourceList.size() > 0 && targetList.size() > 0) {
            int sourceSize = sourceList.size();
            int targetSize = targetList.size();
            if (sourceSize > 200 && targetSize > 200) {
                return true;
            }
            for (int i = 0; i < sourceSize; i++) {
                int[] nextSource = sourceList.pollFirst();
                for (int[] direction : directions) {
                    int nextX = nextSource[0] + direction[0];
                    int nextY = nextSource[1] + direction[1];
                    String strIndex = nextX + "_" + nextY;
                    if (nextX >= 0 && nextX <= maxIndex && nextY >= 0 && nextY <= maxIndex &&
                            !visitedSetSource.contains(strIndex) && !blockedSet.contains(strIndex)) {
                        if (visitedSetTarget.contains(strIndex)) {
                            return true;
                        }
                        visitedSetSource.add(strIndex);
                        sourceList.addLast(new int[]{nextX, nextY});
                    }
                }
            }

            for (int i = 0; i < targetSize; i++) {
                int[] nextTarget = targetList.pollFirst();
                for (int[] direction : directions) {
                    int nextX = nextTarget[0] + direction[0];
                    int nextY = nextTarget[1] + direction[1];
                    String strIndex = nextX + "_" + nextY;
                    if (nextX >= 0 && nextX <= maxIndex && nextY >= 0 && nextY <= maxIndex &&
                            !visitedSetTarget.contains(strIndex) && !blockedSet.contains(strIndex)) {
                        if (visitedSetSource.contains(strIndex)) {
                            return true;
                        }
                        visitedSetTarget.add(strIndex);
                        targetList.addLast(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return false;
    }
}
