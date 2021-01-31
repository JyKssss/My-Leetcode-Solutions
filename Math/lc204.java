package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc204 {
    /**
     * logN 筛选
     * 埃氏筛选
     * 线性筛选
     */
    public int countPrimes(int n) {
        if(n<=1)return 0;
        int[] isPrime=new int[n];
        List<Integer>primeList=new ArrayList<>();
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]==1)primeList.add(i);
            for (int j = 0; j < primeList.size()&&(primeList.get(j)*i)<n; j++) {
                isPrime[primeList.get(j)*i]=0;
                if (i%primeList.get(j)==0)break;
            }
        }
        return primeList.size();
    }
}
