package String;

import java.util.Collections;

public class lc214 {
    public String shortestPalindrome(String s) {
        int base = 26, preOrder = 0, reverOrder = 0, mod = 1000000003, mul = 1;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            preOrder = (int) ((long) (preOrder * base + (s.charAt(i) - 'a')) % mod);
            reverOrder = (int) ((long) ((s.charAt(i) - 'a') * mul + reverOrder) % mod);
            mul = (int) ((long) mul * base % mod);
            if (preOrder == reverOrder) longest = i;
        }

        String prefix = longest==s.length()-1?"": s.substring(longest + 1);
        StringBuffer res = new StringBuffer(prefix).reverse();
        res.append(s);
        return res.toString();

    }

    //解法2 KMP算法中的一部分 查找最长前后缀的方法
    // 1 将原字符串倒序 reverStr 将其作为target 用原字符串 s去匹配 得到在最后的前后缀长度
    // 2 str +"#"+ reverStr 计算前后缀长度
    public static String shortestPalindrome2(String s) {
        StringBuffer pattern=new StringBuffer(s).append("#").append(new StringBuffer(s).reverse());
        int[] next=compute_next(pattern.toString());
        int index=next[next.length-1];
        StringBuffer res=new StringBuffer(s.substring(index)).reverse().append(s);
        return res.toString();
    }
    //kmp算法核心 求解next数组
    //数组next下标从1开始对应 表示前i个子串
    public static int[] compute_next(String pattern){
        int len=pattern.length();
        int[] next=new int[len+1];
        next[0]=-1;next[1]=0;
        int point=2,k=0;//point是next数组的索引

        while (point<=len){
            k=next[point-1];
            if (pattern.charAt(point-1)==pattern.charAt(k))next[point]=k+1;
            else {
                k=next[k];
                while (k>0){
                    if (pattern.charAt(point-1)==pattern.charAt(k)){
                        next[point]=k+1;
                        break;
                    }
                    else k=next[k];
                }
                if (k==0&&pattern.charAt(point-1)!=pattern.charAt(k))next[point]=0;
                else if (k==0&&pattern.charAt(point-1)==pattern.charAt(k))next[point]=1;
            }
            System.out.println("point: "+point+" next: "+next[point]);
            point++;
        }
        return next;
    }

    public static void main(String[] args) {
        String pattern="ababcabababd";
        int[] next=compute_next(pattern);

    }
}
