package Array;

import java.util.ArrayList;
import java.util.List;

public class lc228 {
    public List<String> summaryRanges(int[] nums) {
        List<String>res=new ArrayList<>();
        if (nums==null||nums.length==0)return res;
        int prev=nums[0],cur,start=prev;
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(prev);
        boolean isEnd=true;
        for (int i = 1; i < nums.length; i++) {
            cur=nums[i];
            if (cur-prev==1){
                prev=cur;
            }
            else {
                if (start==prev){
                    res.add(stringBuffer.toString());
                }
                else {
                    stringBuffer.append("->");
                    stringBuffer.append(prev);
                    res.add(stringBuffer.toString());
                }
                stringBuffer=new StringBuffer();
                stringBuffer.append(cur);
                start=cur;
                prev=cur;
            }
        }
        if (start==prev){
            res.add(stringBuffer.toString());
        }
        else {
            stringBuffer.append("->");
            stringBuffer.append(prev);
            res.add(stringBuffer.toString());
        }
        return res;
    }
}
