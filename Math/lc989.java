package Math;

import java.util.ArrayList;
import java.util.List;

public class lc989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer>sum=new ArrayList<>();
        int index=A.length-1,preAdd=0,cur=0;
        while (index>=0 || K>0){
            cur=K%10;
            K=K/10;
            if (index>=0){
                int digit=A[index]+cur+preAdd;
                if (digit>=10){
                    preAdd=1;
                    digit-=10;
                }
                else preAdd=0;
                index--;
                sum.add(0, digit);
            }
            else {
                int digit=cur+preAdd;
                if (digit>=10){
                    preAdd=1;
                    digit-=10;
                }
                else preAdd=0;
                sum.add(0, digit);
            }
        }
        if (preAdd==1)sum.add(0, preAdd);
        return sum;
    }
}
