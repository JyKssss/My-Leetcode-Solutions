package Math;

import java.util.LinkedList;

public class lc60 {
    public String getPermutation(int n, int k) {
        int permutation=1;
        LinkedList<Integer>nums=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            permutation*=(i+1);
            nums.addLast(i+1);
        }
        int res=dfs(n, k-1, permutation, nums);
        return String.valueOf(res);
    }

    public int dfs(int n,int k,int permutation,LinkedList<Integer>nums){
        if (n==0)return 0;
        permutation/=n;
        int total=0,i=0,sum;
        while (total<=k){
            total+=permutation;
            i++;
        }
        i--;
        total-=permutation;
        sum= (int) (nums.get(i)*Math.pow(10, n-1));
        nums.remove(i);
        int suffix=dfs(n-1, k-total, permutation, nums);
        return sum+suffix;
    }
}
