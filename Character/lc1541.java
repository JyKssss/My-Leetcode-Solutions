package Character;

public class lc1541 {
    public int minInsertions(String s) {
        int res=0,leftCol=0,index=0;
        char cur;
        while (index<s.length()){
            cur=s.charAt(index);
            if (cur=='('){
                leftCol++;
            }
            else {
                if (leftCol==0){
                    res++;
                }
                else{
                    leftCol--;
                }

                if (index<s.length()-1 && s.charAt(index+1)==')'){
                    index++;
                }
                else {
                    res++;
                }
            }
            index++;
        }
        res+=2*leftCol;
        return res;
    }
}
