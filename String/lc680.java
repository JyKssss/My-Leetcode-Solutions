package String;

public class lc680 {
    /**
     * 当遇到字符串不匹配的时候 验证两次 左边加一或者右边减一
     * charAt方法比 toCharArray效率高
     * @param s
     * @return
     */
    int mismatchIndex=0;
    public boolean validPalindrome(String s) {
        int len=s.length();
        Boolean res1=verify(s);
        if (res1)return res1;
        else {
            String s1=s.substring(mismatchIndex, len-mismatchIndex-1);
            String s2=s.substring(mismatchIndex+1,len-mismatchIndex);
//            System.out.println(s1+" "+s2);
            return verify(s1)||verify(s2);
        }
    }
    public boolean verify(String s){
        int len=s.length();
//        char[] chars=s.toCharArray();
        for (int i = 0; i <= (len-1)/2; i++) {
            if (s.charAt(i)==s.charAt(len-i-1))continue;
            else {
                mismatchIndex=i;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lc680 l=new lc680();
        System.out.println(l.validPalindrome("abc"));
    }
}
