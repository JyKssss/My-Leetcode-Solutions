package String;

import java.util.HashSet;

public class lc3 {
    /**
     * 从前一个字符到当前字符时 之前终止坐标以前的仍然不重复 可以从这里开始搜索
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0||s.length()==1)return s.length();
        if(s.length()==2)return s.charAt(0)==s.charAt(1)?1:2;
        HashSet<Character>isAppear=new HashSet<>();
        isAppear.add(s.charAt(0));
        int endIndex=0,maxLen=0;
        for (int i = 0; i < s.length(); i++) {
            int start=i;
            if (endIndex==s.length()-1)break;
            for (int j = endIndex+1; j <s.length() ; j++) {
                if (!isAppear.contains(s.charAt(j))){
                    isAppear.add(s.charAt(j));
                    endIndex=j;
                    System.out.println("endIndex： "+endIndex);
                }
                else {
                    isAppear.remove(s.charAt(start));
                    maxLen=(j-start)>maxLen?j-start:maxLen;
                    System.out.println("repeat: "+maxLen);
                    break;
                }
                if (endIndex==s.length()-1){
                    maxLen=endIndex-start+1>maxLen?endIndex-start+1:maxLen;
                    System.out.println("break: "+maxLen);
                    break;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        lc3 l=new lc3();
        System.out.println("res: "+l.lengthOfLongestSubstring("pwwkew"));
    }
}
