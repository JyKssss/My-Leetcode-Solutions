package String;

public class lc28 {
    /**
     * 用kmp实现字符串匹配
     * @param haystack
     * @param needle 模式串
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle==null||needle.length()==0){
            return 0;
        }
        int[][] dfa=kmp(needle);
        int j=0,len=needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            int cur=haystack.charAt(i)-'a';
            j=dfa[j][cur];
            if (j==len){
                return i-len+1;
            }
        }
        return -1;
    }

    private int[][] kmp( String pat){
        int[][] dfa=new int[pat.length()][26];
        int x=0;
        dfa[0][pat.charAt(0)-'a']=1;
        for (int i = 1; i < pat.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (pat.charAt(i)-'a'==j){
                    dfa[i][j]=i+1;
                }
                else {
                    dfa[i][j]=dfa[x][j];
                }
            }
            x=dfa[x][pat.charAt(i)-'a'];
        }
        return dfa;
    }

    public static void main(String[] args) {
        lc28 obj=new lc28();
        String str="mississippi", pat="issip";
        System.out.println(obj.strStr(str, pat));
    }
}
