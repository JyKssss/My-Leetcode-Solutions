package DynamicProgramming;

public class lc70 {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int prev1=1,prev2=2,cur,index=3;
        while (index<=n){
            cur=prev1+prev2;
            prev1=prev2;
            prev2=cur;
            index++;
        }
        return prev2;
    }
}
