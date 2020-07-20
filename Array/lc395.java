package Array;

import java.util.HashMap;

public class lc395 {
    /**
     * 分治法 用hash统计没有达到k值的字符 将他们分开 接着递归
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (s.length()<k)return 0;
        if (k<2)return s.length();
        char[] chars=s.toCharArray();
        return recursive(chars, k, 0, chars.length-1);
    }
    public int recursive(char[] chars,int target,int start,int end){
        int[] charFreq=new int[26];
        for (int i = start; i <= end; i++) {
            charFreq[chars[i]-'a']++;
        }
        //保证左右端不存在<target的字符 这样后期递归处理简单
        while (end-start+1>target && charFreq[chars[start]-'a']<target){
            start++;
        }
        while (end-start+1>target && charFreq[chars[end]-'a']<target){
            end--;
        }
        if (end-start+1<target)return 0;
        for (int i = start; i <=end ; i++) {
            if (charFreq[chars[i]-'a']<target){
                return Math.max(recursive(chars, target, start, i-1), recursive(chars, target, i+1, end));
            }
        }

        return end-start+1;
    }

}
