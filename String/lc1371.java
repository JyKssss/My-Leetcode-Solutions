package String;

import java.util.Arrays;

public class lc1371 {
    /**
     * 思路 前綴表達式 狀態壓縮
     * aeiou 五個字符可以用五位的二進制數來表示各位的奇偶性 status記錄該狀態第一次出現的位置 相減後比較最大長度
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int[] status =new int[1<<5];
        Arrays.fill(status, -1);
        status[0]=0;//開頭全為偶數 無字符
        int cur=0,maxLen=0;
        for (int i = 0; i < s.length(); i++) {
            char curChar=s.charAt(i);
            if (curChar=='a'){
                cur^=(1<<0);
            }else if (curChar=='e'){
                cur^=(1<<1);
            }else if (curChar=='i'){
                cur^=(1<<2);
            }else if (curChar=='o'){
                cur^=(1<<3);
            }else if (curChar=='u'){
                cur^=(1<<4);
            }
            if (status[cur]>=0){
                maxLen=Math.max(i+1-status[cur],maxLen);
            }else {
                status[cur]=i+1;
            }
        }
        return maxLen;
    }
}
