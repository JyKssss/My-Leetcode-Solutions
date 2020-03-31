package Array;

import org.omg.Messaging.SyncScopeHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc18 {
    public static void main(String[] args) {
        int[] nums ={1,0,-1,0,-2,2,3,4};
        int target=0;
        List<List<Integer>> result = fourSum(nums,target);
        System.out.println(result.get(0).toArray().toString());
    }

    /***
     * 双指针法k,j从两侧逼近 ij双层循环 时间复杂度On3
     * 算法优化 4倍的nums[i]>target 可以break
     *         nums[i]+3*nums[length-1]<target continue
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

//        HashSet<List<Integer>> unrepeatSet =new HashSet<>();
        List<List<Integer>>results =new ArrayList<>();
        if (nums.length<4)return results;
        int sum;
        for (int i = 0; i <nums.length-3 ; i++) {
            if (4*nums[i]>target)break;
            if (nums[i]+3*nums[nums.length-1]<target)continue;
            if (i>0 && nums[i]==nums[i-1])continue;
            for (int j = i+1; j < nums.length-2; j++) {
                if (j>i+1 && nums[j]==nums[j-1])continue;
                int k=j+1;
                int l=nums.length-1;
                while (k<l){
                    sum=nums[i]+nums[j]+nums[k]+nums[l];
                    if (sum==target){
                        List<Integer>result =new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        result.add(nums[l]);
                        results.add(result);

                        while (k<l && nums[k]==nums[k+1])k++;
                        while (k<l && nums[l]==nums[l-1])l--;
                        k++;
                        l--;
                    }
                    else if (sum<target){
                        k++;
                    }
                    else if (sum>target){
                        l--;
                    }

                }
            }
        }
        return results;
    }
}
