package String;

import java.util.ArrayList;
import java.util.List;

public class lc14 {
    /**
     * 找字符串数组的最长公共前缀
     * 纵向扫描
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        List<char[]>charList=new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] words=strs[i].toCharArray();
            if (words.length==0)return "";
            charList.add(words);
        }
        boolean isMatch=true;
        int index=0;
        while (isMatch==true){
            if (index>=charList.get(0).length){
                break;
            }
            char pre=charList.get(0)[index];

            for (int i = 0; i < charList.size(); i++) {
                if (index<charList.get(i).length){
                    char cur=charList.get(i)[index];
                    if (cur!=pre){
                        isMatch=false;
                        break;
                    }
                }
                else {
                    isMatch=false;
                    break;
                }
            }
            if (isMatch==true){
                index++;
            }
        }
        if (index==0){
            return "";
        }
        else {
            String res="";
            for (int i = 0; i <index; i++) {
                res=res+charList.get(0)[i];
            }
            return res;
        }
    }

    /**
     * 优化的代码方案 不需要转存为array 熟练使用库函数
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs==null||strs.length==0){
            return "";
        }
        String reg=strs[0];
        for(String str:strs){
            while (!str.startsWith(reg)){
                if (reg.length()==1)return "";
                reg=reg.substring(0, reg.length()-1);
            }
        }
        return reg;
    }
}
