package Array;

import java.util.ArrayList;
import java.util.List;

public class lc561 {
    public int arrayPairSum(int[] nums) {
        int[] buckle=new int[20001];
        for(int n:nums){
            buckle[n+10000]++;
        }
        List<Integer>sortArray=new ArrayList<>();
        for (int i = 0; i < buckle.length; i++) {
            if (buckle[i]>0){
                for (int j = 0; j < buckle[i]; j++) {
                    sortArray.add(i-10000);
                }
            }
        }
        int sum=0;
        for (int i = 0; i < sortArray.size(); i+=2) {
            sum+=sortArray.get(i);
        }
        return sum;
    }
}
