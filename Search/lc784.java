package Search;

import java.util.ArrayList;
import java.util.List;

public class lc784 {
    List<String>result;
    public List<String> letterCasePermutation(String S) {
        result=new ArrayList<>();
        int length=S.length(),index=0;
        String str="";
        dfs(S, str, length, index);
        return result;
    }

    public void dfs(String S, String path, int length, int index){
        if (index<length){
            if (S.charAt(index)>='0'&&S.charAt(index)<='9'){
                String newPath=path+S.charAt(index);
                dfs(S, newPath, length, index+1);
            }
            else {
                String newPath1=path+S.charAt(index);
                String newPath2=null;
                if (S.charAt(index)>='a'&&S.charAt(index)<='z'){
                    newPath2=path+(char) (S.charAt(index)-32);
                }
                else newPath2=path+(char) (S.charAt(index)+32);
                dfs(S, newPath1, length, index+1);
                dfs(S, newPath2, length, index+1);
            }
        }
        else {
            result.add(path);
            return;
        }
    }
}
