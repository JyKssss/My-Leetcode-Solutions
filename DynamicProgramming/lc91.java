package DynamicProgramming;

public class lc91 {
    public int numDecodings(String s) {
        int prev_1=0,prev_2=0,cur;
        if (s.charAt(0)!='0'){
            prev_1=1;
        }
        for (int i = 1; i < s.length(); i++) {
            char curChar=s.charAt(i);
            char prevChar=s.charAt(i-1);
            if (curChar>='1'&&curChar<='9'){
                int val=10*(prevChar-'0')+curChar-'0';
                if (val<=26 && prevChar!='0'){
                    cur=prev_1+prev_2;
                }
                else {
                    cur=prev_1;
                }
            }
            else {
                if (prevChar=='1'||prevChar=='2'){
                    cur=prev_2;
                }
                else {
                    return 0;
                }
            }
            prev_2=prev_1;
            prev_1=cur;
        }
        return prev_1;
    }
}
