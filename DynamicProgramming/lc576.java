package DynamicProgramming;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class lc576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove==0)return 0;
        int[][][] dp=new int[m][n][maxMove+1];
        int[][] directions=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        dp[startRow][startColumn][0]=1;
        int count=0,size,MOD=1000000007;
        Deque<int[]>list=new LinkedList<>();
        list.addLast(new int[]{startRow,startColumn});
        for (int i = 1; i <= maxMove; i++) {
            size=list.size();
            HashSet<String>visitedNode=new HashSet<>();
            for (int j = 0; j < size; j++) {
                int[] cur=list.pollFirst();
                for (int[] direction : directions) {
                    int r=cur[0]+ direction[0],c=cur[1]+direction[1];
                    if (r<0||r>=m||c<0||c>=n){
                        count+=dp[cur[0]][cur[1]][i-1];
                        count%=MOD;
                    }
                    else {
                        if (!visitedNode.contains(r+"_"+c)){
                            list.addLast(new int[]{r,c});
                            visitedNode.add(r+"_"+c);
                        }

                        dp[r][c][i]+=dp[cur[0]][cur[1]][i-1];
                        dp[r][c][i]=dp[r][c][i]%MOD;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        lc576 obj=new lc576();
        System.out.println(obj.findPaths(1, 3, 3, 0, 1));
    }
}
