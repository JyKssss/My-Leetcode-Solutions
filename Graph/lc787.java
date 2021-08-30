package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lc787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, List<Integer>>endStartMap=new HashMap<>();
        int[][] pricesMatrix=new int[n][n];
        int[][] dp =new int[K+2][n];
        int max=10000*101, res=max;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]=max;
            }
        }
        dp[0][src]=0;
        for (int[] flight : flights) {
            List<Integer>startList= endStartMap.getOrDefault(flight[1],new ArrayList<>());
            startList.add(flight[0]);
            endStartMap.put(flight[1], startList);
            pricesMatrix[flight[0]][flight[1]]=flight[2];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                List<Integer>startList=endStartMap.getOrDefault(j, new ArrayList<>());
                for (Integer start : startList) {
                    if (dp[i-1][start]<max){
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][start]+pricesMatrix[start][j]);
                    }
                }
            }
        }
        for (int i = 0; i < K+2; i++) {
            res=Math.min(res, dp[i][dst]);
        }
        return res==max?-1:res;
    }

    public static void main(String[] args) {
        lc787 obj =new lc787();
        int[][] flights=new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(obj.findCheapestPrice(3, flights, 0, 2, 1));
    }
}
