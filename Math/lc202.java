package Math;

import java.util.HashSet;

public class lc202 {
    /**
     * 值出现重复就是false hashset解决问题
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer>hashSet=new HashSet<>();
        int input=n;
        while (true){
            input=computeHappyNum(input);
            if (input==1)return true;
            if (hashSet.contains(input)){
                return false;
            }
            hashSet.add(input);
        }
    }

    public int computeHappyNum(int n){
        String strNum=String.valueOf(n);
        int sum=0;
        for (int i = 0; i < strNum.length(); i++) {
            sum+=Math.pow(Integer.valueOf(strNum.charAt(i)-'0'),2);
        }
        return sum;
    }
}
