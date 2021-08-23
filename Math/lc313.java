package Math;

import java.util.HashSet;
import java.util.PriorityQueue;

public class lc313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long>heap=new PriorityQueue<>();
        HashSet<Long>set=new HashSet<>();
        heap.offer((long) 1);
        set.add((long) 1);
        for (int i = 0; i < n-1; i++) {
            Long cur=heap.poll();
            for (int prime : primes) {
                Long next=cur*prime;
                if (!set.contains(next) && next>0){
                    set.add(next);
                    heap.offer(next);
                }

            }
        }
        int r= Math.toIntExact(heap.poll());
        return r;
    }

    /**
     * dp solution
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int[] indexs=new int[primes.length];
        int[] dp=new int[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            int min= Integer.MAX_VALUE,minIndex=0;
            for (int j = 0; j < primes.length; j++) {
                min=Math.min(min, dp[indexs[j]]*primes[j]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (dp[indexs[j]]*primes[j]==min){
                    indexs[j]++;
                }
            }
            dp[i]=min;
        }
        return dp[n-1];
    }
}
