package Math;

public class lc264 {
    public int nthUglyNumber(int n) {
        int i1=0,i2=0,i3=0,index=1;
        int[] uglyNums=new int[n];
        uglyNums[0]=1;
        while (index<n){
            int n1=uglyNums[i1]*2,n2=uglyNums[i2]*3,n3=uglyNums[i3]*5,min=Math.min(n1, Math.min(n2,n3));
            uglyNums[index]=min;
            if (n1==min){
                i1++;
            }
            if (n2==min){
                i2++;
            }
            if (n3==min){
                i3++;
            }
            index++;
        }
        return uglyNums[n-1];
    }

    public static void main(String[] args) {
        int n=10;
        lc264 obj=new lc264();
        System.out.println(obj.nthUglyNumber(n));
    }
}
