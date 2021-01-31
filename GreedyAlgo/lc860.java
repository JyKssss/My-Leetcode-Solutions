package GreedyAlgo;

public class lc860 {
    public boolean lemonadeChange(int[] bills) {
        int count5=0,count10=0;
        for(int bill:bills){
            if (count5<0)return false;
            if (bill==5)count5++;
            else if (bill==10){
                count10++;
                count5--;
            }
            else {
                if (count10>0){
                    count10--;
                    count5--;
                }
                else {
                    count5-=3;
                }
            }
        }
        if (count5<0)return false;
        return true;
    }
}
