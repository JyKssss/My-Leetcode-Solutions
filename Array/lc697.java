package Array;

import java.util.ArrayList;
import java.util.List;

public class lc697 {
    public int findShortestSubArray(int[] nums) {
        int[] numCnt=new int[50000];
        int max=0;
        List<List<Integer>> numIndex=new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            numIndex.add(new ArrayList<>());
        }
        for (int i = 0; i < nums.length; i++) {
            numCnt[nums[i]]++;
            max=Math.max(max, numCnt[nums[i]]);
            numIndex.get(nums[i]).add(i);
        }
        List<Integer>target=new ArrayList<>();

        for (int i = 0; i < numCnt.length; i++) {
            if (numCnt[i]==max){
                target.add(i);
            }
        }
        int res= nums.length;
        for(int targetIndex:target){
            List<Integer>indexs=numIndex.get(targetIndex);
            res=Math.min(res, indexs.get(indexs.size()-1)-indexs.get(0)+1);
        }
        return res;
    }
}
