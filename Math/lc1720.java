package Math;

public class lc1720 {

    public int[] decode(int[] encoded, int first) {
        int []res=new int[encoded.length+1];
        res[0]=first;
        for (int i = 1; i < res.length ; i++) {
            first=first^ encoded[i-1];
            res[i]=first;
        }
        return res;
    }
}
