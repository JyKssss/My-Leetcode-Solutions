package Math;

import java.util.Arrays;
import java.util.HashSet;

public class offer38 {
    HashSet<String>res;
    String s;
    public String[] permutation(String s) {
        this.res=new HashSet<>();
        this.s=s;
        dfs(new char[s.length()], 0);
        String[] strings=new String[res.size()];
        int i=0;
        for (String re : res) {
            strings[i]=re;
            i++;
        }
        return strings;
    }

    private void dfs(char[] chars,int index){
        if (index==s.length()){
            res.add(String.valueOf(chars));
            return;
        }
        char cur=s.charAt(index);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!=0){
                continue;
            }
            chars[i]=cur;
            dfs(chars, index+1);
            chars[i]=0;
        }
    }


    public static void main(String[] args) {
        offer38 obj=new offer38();
        String s="abc";
        System.out.println(Arrays.toString(obj.permutation(s)));
    }
}
