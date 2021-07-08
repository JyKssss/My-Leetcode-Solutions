package Math;

public class lc168 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber<=0){
            return "";
        }
        StringBuffer stringBuffer=new StringBuffer();
        while (columnNumber>0){
            columnNumber--;
            stringBuffer.insert(0, (char)(columnNumber%26+'A'));
            columnNumber/=26;
        }
        return stringBuffer.toString();
    }
}
