package Array;

import java.util.HashMap;

public class ms56 {
    public int[] singleNumbers(int[] nums) {
        HashMap<Integer,Integer>numMap=new HashMap<>();
        int[] res=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!numMap.containsKey(nums[i])){
                numMap.put(nums[i],1);
            }
            else {
                numMap.remove(nums[i]);
            }
        }
        int index=0;
        for (Integer integer:numMap.keySet()) {
            if (numMap.get(integer)==1){
                res[index]=integer;
                index++;
            }
        }
        return res;
    }
}
