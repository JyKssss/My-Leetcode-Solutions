package List;


import java.util.*;

public class lc1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]> workerBikeList = new ArrayList<>();
        int[] res = new int[workers.length];
        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                workerBikeList.add(new int[]{manhattanDis(worker, bike), i, j});
            }
        }

        Collections.sort(workerBikeList, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[2] - o2[2];
            }
        });
        HashSet<Integer> workerSet = new HashSet<>();
        HashSet<Integer> bikeSet = new HashSet<>();
        for (int[] pair : workerBikeList) {
            if (!workerSet.contains(pair[1]) && !bikeSet.contains(pair[2])) {
                res[pair[1]] = pair[2];
                workerSet.add(pair[1]);
                bikeSet.add(pair[2]);
            }
        }
        return res;
    }

    private int manhattanDis(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
