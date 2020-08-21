package String;

public class lc415 {
    public String addStrings(String num1, String num2) {
        int len=Math.min(num1.length(), num2.length()),i=0,len1=num1.length()-1,len2=num2.length()-1;
        StringBuffer stringBuffer =new StringBuffer();
        boolean addnext=false;
        while (i<len){
            int add=num1.charAt(len1-i)-'0'+num2.charAt(len2-i)-'0';
            if (addnext)add+=1;
            if (add>=10)addnext=true;
            else addnext=false;
            add=add%10;
            stringBuffer.insert(0, add);
            i++;
        }
        i=len+1;
        String extra=num1.length()>len?num1:num2;
        while (i<=extra.length()){
            int add=extra.charAt(extra.length()-i)-'0';
            if (addnext)add++;
            if (add>=10)addnext=true;
            else addnext=false;
            add=add%10;
            stringBuffer.insert(0, add);
            i++;
        }
        if (addnext)stringBuffer.insert(0, 1);
        return stringBuffer.toString();
    }
}
