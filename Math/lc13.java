package Math;

public class lc13 {
    public int romanToInt(String s) {
        int[] val={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rome={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int index=0,res=0;
        while (index<rome.length && s.length()>0){
            String start=rome[index];
            if (s.startsWith(start)){
                res+=val[index];
                s=s.substring(start.length());
            }
            else {
                index++;
            }
        }
        return res;
    }
}
