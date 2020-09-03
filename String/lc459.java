package String;

public class lc459 {
    public boolean repeatedSubstringPattern(String s) {
        String dString=s+s;
        dString=dString.substring(1, dString.length()-1);
        if (dString.contains(s))return true;
        else return false;
    }
}
