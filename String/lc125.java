package String;

public class lc125 {
    public boolean isPalindrome(String s) {
        if (s.length()==0)return true;
        if (s.equals(" "))return true;
        s=s.toLowerCase();
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                stringBuffer.append(s.charAt(i));
            }
            else continue;
        }
        s=stringBuffer.toString();
        if (s.length()==0)return false;
        for (int i = 0; i < (s.length()-1)/2; i++) {
//            System.out.println(s.charAt(i)+" "+s.charAt(s.length()-1-i));
            if (s.charAt(i)==s.charAt(s.length()-1-i)){
                continue;
            }
            else return false;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        if (s.length()==0||s.length()==1)return true;
        if (s.equals(" "))return true;
        s=s.toLowerCase();
        int start=0,end=s.length()-1;
        while (start<end){
            char left,right;
            while (!((s.charAt(start)>='0'&&s.charAt(start)<='9')||(s.charAt(start)>='a'&&s.charAt(start)<='z')||(s.charAt(start)>='A'&&s.charAt(start)<='Z'))){
                if (start<end)start++;
                else break;
            }
            while (!((s.charAt(end)>='0'&&s.charAt(end)<='9')||(s.charAt(end)>='a'&&s.charAt(end)<='z')||(s.charAt(end)>='A'&&s.charAt(end)<='Z'))){
                if (start<end)end--;
                else break;
            }
            if (start<end){
                left=s.charAt(start);
                right=s.charAt(end);
            }
            else break;
            if (left!=right)return false;
            else {
                start++;
                end--;
                continue;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lc125 l=new lc125();
        System.out.println(l.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
