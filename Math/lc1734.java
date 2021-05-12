package Math;

public class lc1734 {
    public int[] decode(int[] encoded) {
        int allXOR=0,allXORFirst=0;
        for (int i = 1; i < encoded.length; i+=2) {
            allXORFirst^=encoded[i];
        }
        for (int i = 1; i <= encoded.length+1 ; i++) {
            allXOR^=i;
        }
        int[] res=new int[encoded.length+1];
        res[0]=allXOR^allXORFirst;
        for (int i = 1; i < res.length ; i++) {
            res[i]=res[i-1]^encoded[i-1];
        }

        return res;
    }

}
