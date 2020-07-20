package Array;

import com.sun.glass.ui.Size;

import java.util.HashMap;
import java.util.HashSet;

public class lc128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>numSet=new HashSet<>();
        int maxLen=0,len=0;
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int cur=nums[i];

            if (numSet.contains(cur-1))continue;
            else {
                while (numSet.contains(cur)){
                    len++;
                    cur++;
                }
                maxLen=Math.max(maxLen, len);
                len=0;
            }
        }
        return maxLen;
    }

    /**
     * 使用并查集解决问题
     * @param nums
     * @return
     */
    HashMap<Integer,Integer>UF ;
    HashMap<Integer, Integer>size;
    int maxSize=1;
    public int longestConsecutive2(int[] nums) {
        if (nums.length==0||nums==null)return 0;
        UF=new HashMap<>();
        size=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!UF.containsKey(nums[i])){
                UF.put(nums[i],nums[i]);
                size.put(nums[i],1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (UF.containsKey(nums[i]+1)){
                if (find(nums[i])!=find(nums[i]+1)){
                    merge(nums[i],nums[i]+1);
                }
            }
        }
        return maxSize;
    }

    public int find(int k){
        int father=k== UF.get(k)?k:find(UF.get(k));
        return father;
    }
    public void merge(int a, int b){
        int fa=find(a),fb=find(b);
        UF.replace(b, fa);
        size.replace(fa, size.get(fa)+size.get(fb));
        maxSize=Math.max(maxSize,size.get(fa));
    }
}
