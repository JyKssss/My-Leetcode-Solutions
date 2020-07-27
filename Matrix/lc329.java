package Matrix;

import java.util.Arrays;
import java.util.Comparator;

public class lc329 {
    /**
     * DP解法
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        int size=matrix.length*matrix[0].length;
        node[] nodes=new node[size];
        int index=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nodes[index]=new node(i, j, matrix[i][j]);
                index++;
            }
        }
        Arrays.sort(nodes, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.val-o2.val;
            }
        });

        int[][] dp=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]++;
            }
        }
        int maxi=matrix.length-1,maxj=matrix[0].length-1,max=0;
        for (node node :nodes) {
            int i=node.i,j=node.j,add=0;
            if (i>0&&node.val>matrix[i-1][j])add=Math.max(add, dp[i-1][j]);
            if (i<maxi&&node.val>matrix[i+1][j])add=Math.max(add, dp[i+1][j]);
            if (j>0&&node.val>matrix[i][j-1])add=Math.max(add, dp[i][j-1]);
            if (j<maxj&&node.val>matrix[i][j+1])add=Math.max(add, dp[i][j+1]);
            dp[i][j]+=add;
            max=Math.max(max, dp[i][j]);
        }
        return max;
    }

    private class node{
        int i,j,val;

        public node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    /**
     * 记忆化DFS
     * @param matrix
     * @return
     */
    public int longestIncreasingPath2(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        boolean[][] isVisited=new boolean[matrix.length][matrix[0].length];
        int[][] dfs=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs[i][j]++;
            }
        }
        int maxLen=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!isVisited[i][j])maxLen=Math.max(dfsHelper(i, j, matrix,dfs, isVisited),maxLen);
            }
        }
        return maxLen;
    }

    public int dfsHelper(int i, int j, int[][] matrix,int[][] dfs,boolean[][] isVisited){
        int len=1,add=0;
        if (i>0&&matrix[i-1][j]<matrix[i][j]){
            if (!isVisited[i-1][j])add=Math.max(add, dfsHelper(i-1, j, matrix,dfs, isVisited));
            else add=Math.max(add, dfs[i-1][j]);
        }
        if (j>0&&matrix[i][j-1]<matrix[i][j]){
            if (!isVisited[i][j-1])add=Math.max(add, dfsHelper(i, j-1, matrix,dfs, isVisited));
            else add=Math.max(add, dfs[i][j-1]);
        }
        if (i<matrix.length-1&&matrix[i+1][j]<matrix[i][j]){
            if (!isVisited[i+1][j])add=Math.max(add, dfsHelper(i+1, j, matrix,dfs, isVisited));
            else add=Math.max(add, dfs[i+1][j]);
        }
        if (j<matrix[0].length-1&&matrix[i][j+1]<matrix[i][j]){
            if (!isVisited[i][j+1])add=Math.max(add, dfsHelper(i, j+1, matrix,dfs, isVisited));
            else add=Math.max(add, dfs[i][j+1]);
        }
        len+=add;
        dfs[i][j]=len;
        isVisited[i][j]=true;
        return len;
    }
}
