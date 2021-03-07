package String;

import java.util.ArrayList;
import java.util.List;

public class lc131 {
    public List<List<String>> partition(String s) {
        //dp求解出s中所有的回文串
        boolean[][] palTable =new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            palTable[i][i]=true;
        }

        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i+1; j <s.length() ; j++) {
                if (j-i>1){
                    palTable[i][j]=(s.charAt(i)==s.charAt(j))&&palTable[i+1][j-1];
                }
                else {
                    palTable[i][j]=(s.charAt(i)==s.charAt(j));
                }
            }
        }
        List<List<String>> res=new ArrayList<>();
        List<String>sepList=new ArrayList<>();
        helper(0, s.length(), sepList, res, palTable, s);
        return res;
    }

    public void helper(int start, int len,List<String> sepList, List<List<String>> res,boolean[][] palTable, String s){
        if (start==len){
            res.add(new ArrayList<>(sepList));
        }
        for (int i = start; i <len ; i++) {
            if (palTable[start][i]){
                sepList.add(s.substring(start, i+1));
                helper(i+1, len, sepList, res, palTable, s);
                sepList.remove(sepList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        lc131 obj=new lc131();
        String s="bb";
        List<List<String>> res= obj.partition(s);
        for(List<String>sep: res){
            System.out.println(sep.toString());
        }
    }
}
