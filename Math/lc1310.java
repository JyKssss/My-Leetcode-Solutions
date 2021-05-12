package Math;

public class lc1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] num=new int[arr.length+1], res=new int[queries.length];
        for (int i = 1; i < num.length ; i++) {
            num[i]=num[i-1]^arr[i-1];
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query=queries[i];
            res[i]=num[query[1]+1]^num[query[0]];
        }
        return res;
    }
}
