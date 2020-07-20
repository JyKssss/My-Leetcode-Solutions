package DynamicProgramming;

public class ms46 {
    public int translateNum(int num) {
        String str=String.valueOf(num);
        if (str.length()<=1)return str.length();
        int pre1,pre2,cur,tmp;
        char preChar1=str.charAt(0),preChar2=str.charAt(1),curChar;
        pre1=1;
        tmp=10*Integer.valueOf(preChar1-'0')+Integer.valueOf(preChar2-'0');
        System.out.println(tmp);
        if (tmp>=10&&tmp<=25)pre2=2;
        else pre2=1;
        for (int i = 2; i <str.length() ; i++) {
            curChar=str.charAt(i);
            tmp=10*Integer.valueOf(preChar2-'0')+Integer.valueOf(curChar-'0');
            if (tmp>=10&&tmp<=25)cur=pre1+pre2;
            else cur=pre2;
            pre1=pre2;
            pre2=cur;
            preChar1=preChar2;
            preChar2=curChar;
        }
        return pre2;
    }
}
