package String;

import java.util.HashMap;

public class lc10 {
    /**
     * 正则表达式匹配
     * @param s
     * @param p
     * @return
     */

    HashMap<String,Boolean>dpTable;
    int strLen,patLen;
    public boolean isMatch(String s, String p) {
        this.strLen=s.length();
        this.patLen=p.length();
        this.dpTable=new HashMap<>();
        return dp(s, 0, p, 0);
    }

    public boolean dp(String s,int i,String p,int j){
        //截止条件
        if (j==patLen){
            return i==strLen;
        }
        else if (i==strLen){
            if ((patLen-j)%2==1){
                return false;
            }
            for(;j<patLen-1;j+=2){
                if (p.charAt(j+1)!='*'){
                    return false;
                }
            }
            return true;
        }

        String key=String.valueOf(i)+","+String.valueOf(j);
        if (dpTable.containsKey(key)){
            return dpTable.get(key);
        }
        boolean res;
        if (s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
            if (j<patLen-1 && p.charAt(j+1)=='*'){
                res= dp(s, i, p, j+2)||dp(s, i+1, p, j);
            }
            else {
                res= dp(s, i+1, p, j+1);
            }
        }
        else {
            if (j<patLen-1 && p.charAt(j+1)=='*'){
                res= dp(s, i, p, j+2);
            }
            else {
                res=false;
            }
        }
        dpTable.put(key, res);
        return res;
    }
}
