package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList[] richerList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            richerList[i] = new ArrayList<>();
        }
        int[] startList = new int[n];
        for (int[] r : richer) {
            startList[r[0]] = 1;
            richerList[r[1]].add(r[0]);
        }
        List<Integer>startNodes = new ArrayList<>();
        for (int i = 0; i < startList.length; i++) {
            if (startList[i] == 0) {
                startNodes.add(i);
            }
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);
        dfsSearch(startNodes, quiet,richerList, res);
        return res;
    }

    private void dfsSearch(List<Integer>startNodes, int[] quiet, List<Integer>[] richerList, int[] res) {
        for (Integer startNode : startNodes) {
            dfs(startNode, quiet, richerList, res);
        }
    }

    private int dfs(int node, int[] quiet, List<Integer>[] richerList, int[] res) {
        List<Integer> rList = richerList[node];
        int smallestQuiet = Integer.MAX_VALUE;
        int smallestNode = Integer.MAX_VALUE;
        for (Integer nextN : rList) {
            int index;
            if (res[nextN] == -1) {
                index = dfs(nextN, quiet, richerList, res);
            } else {
                if (quiet[nextN] <= quiet[res[nextN]]) {
                    index = nextN;
                } else {
                    index = res[nextN];
                }
            }
            if (quiet[index] < smallestQuiet) {
                smallestQuiet = quiet[index];
                smallestNode = index;
            }
        }

        if (quiet[node] < smallestQuiet) {
            smallestQuiet = quiet[node];
            smallestNode = node;
        }
        res[node] = smallestNode;
        return smallestNode;
    }

    public static void main(String[] args) {
        lc851 obj = new lc851();
        int[][] richer = new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = new int[]{3,2,5,4,6,1,7,0};
        System.out.println(Arrays.toString(obj.loudAndRich(richer, quiet)));
    }
}
