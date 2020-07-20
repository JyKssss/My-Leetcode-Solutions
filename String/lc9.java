package String;

public class lc9 {
    public boolean isPalindrome(int x) {
        String numStr=String.valueOf(x);
        if (numStr.length()<=1)return true;
        int i=0,j=numStr.length()-1;
        while (i<j){
            if (numStr.charAt(i)!=numStr.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
