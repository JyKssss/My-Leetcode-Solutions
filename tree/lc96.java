package tree;

public class lc96 {
    public int numTrees(int n) {
//        return helper(n);
        return helperDP(n);
    }

    /**
     * 递归效率很低
     * @param length
     * @return
     */
    public int helper(int length){
        int treeNum=0;
        if (length==0)return 1;//无子树也是一种情况 不要忽略
        if (length==1)return 1;
        for (int i = 0; i < length; i++) {
            treeNum+=helper(i)*helper(length-i-1);
        }
        return treeNum;
    }

    /**
     * DP解法
     * G(n)=f(1)+f(2)+...+f(n) 1-n中能组成多少树
     * f(k)=G(k-1)*G(n-k)  以k为根节点
     * G(n)=G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)
     */
    public int helperDP(int length){
        if (length==1)return 1;
        if (length==0)return 0;
        int[] gNum=new int[length+1];
        gNum[0]=1;
        gNum[1]=1;
        for (int i = 1; i <=length ; i++) {
            int sum=0;
            for (int j = 0; j < i; j++) {
                sum+=gNum[j]*gNum[i-j-1];
            }
            gNum[i]=sum;
        }
        return gNum[length];
    }
}
