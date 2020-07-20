package String;

import java.util.List;

public class lc524 {
    public String findLongestWord(String s, List<String> d) {
        String maxRes="";
        int sPoint=0,dPoint=0;
        for (int i = 0; i < d.size(); i++) {
            String dstr=d.get(i);
            if (dstr.length()<maxRes.length())continue;
            sPoint=0;
            dPoint=0;
            while (dPoint!=dstr.length()&&sPoint!=s.length()){
                if (s.charAt(sPoint)==dstr.charAt(dPoint)){
                    sPoint++;
                    dPoint++;
                }
                else sPoint++;
            }
            if (dPoint==dstr.length()){
                if (dstr.length()>maxRes.length())maxRes=dstr;
                else if (dstr.length()==maxRes.length()&&maxRes.compareTo(dstr)>0)maxRes=dstr;
            }
        }
        return maxRes;
    }

}
