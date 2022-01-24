package Graph;

import java.util.*;

public class lc261 {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false;
            }
        }
        return uf.connectedComp == 1;
    }

    class UnionFind {
        int[] fatherList;
        int connectedComp;
        public UnionFind(int size) {
            this.fatherList = new int[size];
            for (int i = 0; i < fatherList.length; i++) {
                fatherList[i] = i;
            }
            this.connectedComp = size;
        }

        public boolean union(int a, int b) {
            int fatherA = findParent(a);
            int fatherB = findParent(b);
            if (fatherA == fatherB) {
                return false;
            }
            connectedComp -= 1;
            fatherList[fatherB] = fatherA;
            return true;
        }

        private int findParent(int a) {
            while (fatherList[a] != a) {
                a = fatherList[a];
            }
            return a;
        }
    }

    public boolean validTree2(int n, int[][] edges) {
        int[][] connectMatrix = new int[n][n];
        for (int[] edge : edges) {
            connectMatrix[edge[0]][edge[1]] = 1;
            connectMatrix[edge[1]][edge[0]] = 1;
        }

        Set<Integer> set = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        set.add(0);
        while (deque.size() > 0) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int node = deque.pollFirst();
                for (int j = 0; j < connectMatrix[node].length; j++) {
                    if (connectMatrix[node][j] == 1) {
                        if (set.contains(j)) {
                            return false;
                        }
                        deque.addLast(j);
                        set.add(j);
                        connectMatrix[node][j] = 0;
                        connectMatrix[j][node] = 0;
                    }
                }
            }
        }
        return set.size() == n;
    }
}
