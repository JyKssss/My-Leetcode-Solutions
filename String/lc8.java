package String;

public class lc8 {
    public int myAtoi(String str) {
        StringBuffer stringBuffer =new StringBuffer();
        boolean findNum=false, positive=true, biggerZero=false;
        int index=0;
        while (index<str.length()){
            char cur=str.charAt(index);
            if (cur==' '&&!findNum){
                index++;
                continue;
            }
            else if (cur=='-'&&!findNum){
                positive=false;
                findNum=true;
            }
            else if (cur=='+'&&!findNum){
                findNum=true;
            }
            else if ((cur<'0'||cur>'9'))break;
            else if (cur>='0'&&cur<='9'){
                if (!biggerZero&&cur=='0'){
                    findNum=true;
                    index++;
                    continue;
                }
                biggerZero=true;
                stringBuffer.append(cur);
                findNum=true;
            }
            index++;
        }

        if (stringBuffer.length()==0)return 0;
        if (!positive)stringBuffer.insert(0, '-');
        String resStr=stringBuffer.toString();
        if (resStr.length()>11)return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        if (resStr.length()<10)return Integer.valueOf(resStr);
        long res=Long.valueOf(resStr);
        if (res>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if (res<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return Integer.valueOf(resStr);
    }
}
