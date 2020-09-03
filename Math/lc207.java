package Math;
//本质上寻找最大前缀
public class lc207 {
    public int rangeBitwiseAnd(int m, int n) {
        int mask=1<<30;
        int ans=0;
        while (mask>0&&(m&mask)==(n&mask)){
            ans|=m&mask;
            mask>>=1;
        }
        return ans;
    }
}
