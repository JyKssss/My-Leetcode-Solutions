package Math;

public class lc461 {
    public int hammingDistance(int x, int y) {
        int xor= x^y, dis=0;
        for (int i = 0; i < 31; i++) {
            dis+= (xor&1);
            xor=xor >>1;
        }
        return dis;
    }
}
