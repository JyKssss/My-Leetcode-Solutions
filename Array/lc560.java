package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, List<Integer>>valueIndexMap=new HashMap<>();
        int sum=0;
        valueIndexMap.put(sum, new ArrayList<Integer>(){{add(-1);}});
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if (valueIndexMap.containsKey(sum)){
                valueIndexMap.get(sum).add(i);
            }
            else {
                List<Integer>addList=new ArrayList<>();
                addList.add(i);
                valueIndexMap.put(sum, addList);
            }
        }
        int res=0;
        for(Integer toSum:valueIndexMap.keySet()){
            if (!valueIndexMap.containsKey(toSum+k)){
                continue;
            }
            else {
                List<Integer>startIndexList=valueIndexMap.get(toSum);
                List<Integer>endIndexList=valueIndexMap.get(toSum+k);
                for (int i = 0; i <startIndexList.size() ; i++) {
                    for (int j = 0; j < endIndexList.size(); j++) {
                        int start=startIndexList.get(i);
                        int end=endIndexList.get(j);
                        if (start<end)res++;
                    }
                }
            }


        }
        return res;
    }

    /**
     * 简化的前缀和＋hashmap解决方法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count=0,sum=0;
        //key：sum value：num
        HashMap<Integer,Integer>valueNumMap=new HashMap<>();
        valueNumMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (valueNumMap.containsKey(sum-k))count+=valueNumMap.get(sum-k);
            if (valueNumMap.containsKey(sum)){
                valueNumMap.replace(sum, valueNumMap.get(sum)+1);
            }
            else valueNumMap.put(sum, 1);

        }
        return count;
    }
}
