package String;

public class lc12 {
    /**
     * 数字转为罗马数字 贪心算法
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] val={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rome={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < val.length; i++) {
            while (num>val[i]){
                stringBuffer.append(rome[i]);
                num-=val[i];
            }
        }
        return stringBuffer.toString();
    }
}
