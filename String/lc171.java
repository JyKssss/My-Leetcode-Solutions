package String;

public class lc171 {
    public int titleToNumber(String columnTitle) {
        if (columnTitle==null| columnTitle.length()==0){
            return 0;
        }
        int res=0,cur=1;
        for (int i = columnTitle.length()-1; i >=0 ; i--) {
            res+=cur*(columnTitle.charAt(i)-'A');
            cur*=26;
        }
        return res+1;
    }
}
