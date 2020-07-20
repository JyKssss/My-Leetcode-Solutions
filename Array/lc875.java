package Array;

public class lc875 {
    public int minEatingSpeed(int[] piles, int H) {
        long total = 0;
        int minK=1,maxK=0,res=Integer.MAX_VALUE;
        for (int i = 0; i < piles.length; i++) {
            maxK=piles[i]>maxK?piles[i]:maxK;
        }
        while (minK <= maxK) {
            int midK = (minK + maxK + 1) / 2;
            int count = 0;
            for (int i = 0; i < piles.length; i++) {
                count+=(piles[i]-1)/midK +1;
            }
            if (count <=H) {
                maxK = midK - 1;
                res = res > midK ? midK : res;
//                System.out.println(res);
            } else {
                minK = midK + 1;
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        lc875 l=new lc875();
        int[] piles={332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        int H=823855818;
        System.out.println(l.minEatingSpeed(piles, H));
    }
}
