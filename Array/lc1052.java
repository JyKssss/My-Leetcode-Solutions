package Array;

public class lc1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int[] customersWithMinus=new int[customers.length];
        int totalOrg=0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i]==0){
                customersWithMinus[i]=customers[i];
                totalOrg+=customers[i];
            }
            else {
                customersWithMinus[i]=-customers[i];
            }
        }
        int left=0,right=0,res=totalOrg;
        while (right<customers.length){
            if (right-left+1<=X){
                if (customersWithMinus[right]<0){
                    totalOrg+=-customersWithMinus[right];
                    res=Math.max(res, totalOrg);
                }
                right++;
            }
            else {
                if (customersWithMinus[right]<0){
                    totalOrg+=-customersWithMinus[right];
                }
                if (customersWithMinus[left]<0){
                    totalOrg+=customersWithMinus[left];
                }
                res=Math.max(res, totalOrg);
                left++;
                right++;
            }
        }
        return res;
    }
}
