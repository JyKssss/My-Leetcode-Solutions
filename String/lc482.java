package String;

public class lc482 {
    public String licenseKeyFormatting(String s, int k) {
        int cnt=0,upper='A'-'a';
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = s.length()-1; i >=0 ; i--) {
            char cur=s.charAt(i);
            if (cur=='-'){
                continue;
            }
            if (cur>='a'&&cur<='z'){
                cur+=upper;
            }
            cnt++;
            stringBuffer.append(cur);
            if (cnt==k&&i>0){
                cnt=0;
                stringBuffer.append('-');
            }
        }
        while (stringBuffer.length()>0&&stringBuffer.charAt(stringBuffer.length()-1)=='-'){
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        return stringBuffer.reverse().toString();
    }
}
