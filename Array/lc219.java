package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lc219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>>nearbyMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!nearbyMap.containsKey(nums[i])){
                nearbyMap.put(nums[i],new ArrayList<>(Arrays.asList(i)));
            }
            else {
                List<Integer>indexList=nearbyMap.get(nums[i]);
                for (int j = 0; j < indexList.size(); j++) {
                    if (Math.abs(indexList.get(j)-i)<=k){
                        return true;
                    }
                    else continue;
                }
                indexList.add(i);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer>nearbyMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!nearbyMap.containsKey(nums[i])){
                nearbyMap.put(nums[i],i);
            }
            else {
                if (Math.abs(nearbyMap.get(nums[i])-i)<=k){
                    return true;
                }
                else nearbyMap.replace(nums[i],i);
            }
        }
        return false;
    }
}
