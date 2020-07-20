package String;

import java.util.*;

public class lc820 {
    /**
     * 将所有字符串倒序后 按字符串排序 如果字符串能合并一定是和自己后面的合并（比前面的大）
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        for (int i = 0; i < words.length; i++) {
            words[i]=new  StringBuffer(words[i]).reverse().toString();
        }
        Arrays.sort(words, (o1, o2) -> o1.compareTo(o2));
        int res=0;
        for (int i = 0; i < words.length; i++) {
            if (i==words.length-1){
                res+=words[i].length()+1;
                break;
            }
            if (!words[i+1].startsWith(words[i])){
                res+=words[i].length()+1;
            }
        }
        return res;
    }
}
