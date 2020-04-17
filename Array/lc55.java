package Array;

import java.util.*;

public class lc55 {
    /**
     * BFS时间超限 算是暴力解了 寻找所有可能的点
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int length=nums.length;
        Queue<Integer> step=new LinkedList<>();
        HashSet<Integer>visitedStep=new HashSet<>();
        visitedStep.add(0);
        step.add(0);
        int singleLength;
        while (!visitedStep.isEmpty()){
            singleLength=step.size();
            for (int i = 0; i < singleLength; i++) {
                int index=step.poll();
                int maxStep=nums[index];
                for (int j = 1; j <=maxStep ; j++) {
                    if (!visitedStep.contains(index+j)&&(index+j)<length){
                        visitedStep.add(index+j);
                        step.add(index+j);
                        if (index+j==length-1)return true;
                    }
                }
            }
            if (step.isEmpty())break;
        }
        return visitedStep.contains(length-1);
    }

    /**
     * 倒序查找 On
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums){
        if(nums.length==1)return true;
        int zeroIndex=0;
        boolean canReach=true;
        for (int i = nums.length-2; i >=0 ; i--) {
            if (nums[i]>0){
                if (canReach)continue;
                if (!canReach){
                    if (i+nums[i]>zeroIndex){
                        canReach=true;
                        continue;
                    }
                    else continue;
                }
            }
            else {
                if (canReach){
                    canReach=false;
                    zeroIndex=i;
                }
                else continue;
            }

        }
        return canReach;
    }
}
