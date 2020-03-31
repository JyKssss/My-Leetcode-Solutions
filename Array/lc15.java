package Array;

import org.omg.Messaging.SyncScopeHelper;

import java.lang.reflect.Array;
import java.util.*;

public class lc15 {
    public static void main(String[] args) {
        int[] input= {-1,0,1,2,-1,-4};
        threeSum(input);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> numSet = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            numSet.put(i, nums[i]);
        }
        int targetNum;
        HashSet<List<Integer>> results = new HashSet<>();
        List<List<Integer>> resultsArray = new ArrayList<>();

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                List<Integer> result = new ArrayList<>();
                targetNum = -(nums[i]+nums[j]);
                if (targetNum<nums[j]){
                    break;
                }
                numSet.remove(i);
                numSet.remove(j);
                if (numSet.containsValue(targetNum)){
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(targetNum);
                    result.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            int i = o1>o2 ? 1:-1;
                            if (o1==o2){
                                i=0;
                            }
                            return i;
                        }
                    });
                    results.add(result);
                }
                numSet.put(i, nums[i]);
                numSet.put(j, nums[j]);
            }
        }

        for(List<Integer>i : results){
            resultsArray.add(i);
            System.out.println(i.toArray().length );
        }
        return resultsArray;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        int k,j,sum;
        for (int i = 0; i <nums.length-2 ; i++) {
            if (nums[i]>0){
                break;
            }
            if (i>0&&nums[i]==nums[i-1])continue;
            k=i+1;
            j=nums.length-1;
            while (k<j){
                sum = nums[i]+nums[k]+nums[j];
                if (sum==0){
                    List<Integer> result =new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[k]);
                    result.add(nums[j]);
                    results.add(result);
                    while (k<j && nums[k]==nums[k+1]) k++;
                    while (k<j && nums[j]==nums[j-1]) j--;
                    k++;
                    j--;
                }
                else if (sum<0){
                    k++;
                }
                else if (sum>0){
                    j--;
                }
            }
        }
        return results;
    }
}
