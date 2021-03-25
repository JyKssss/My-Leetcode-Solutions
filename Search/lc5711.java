package Search;

public class lc5711 {
    public int maxValue(int n, int index, int maxSum) {
        int leftSize=index, rightSize=n-index-1, curNum=maxSum-n, lower=1,upper=curNum+1;
        while (lower<upper){
            int mid=lower+(upper-lower)/2;
            if (verify(leftSize, rightSize,  curNum, mid)){
                lower=mid+1;
            }
            else {
                upper=mid-1;
            }
        }
        if (verify(leftSize, rightSize, curNum, lower)){
            return lower;
        }
        else return lower-1;
    }

    private boolean verify(long leftSize, long rightSize,  int curNum, long h){
        long sum=0;
        if (rightSize>=h-2){
            sum+=(h-1)*(h-2)/2;
        }
        else {
            sum+=(2*h-rightSize-3)*rightSize/2;
        }

        if (leftSize>=h-2){
            sum+=(h-1)*(h-2)/2;
        }
        else {
            sum+=(2*h-leftSize-3)*leftSize/2;
        }
        sum+=h-1;
        return sum<=curNum;
    }

    public static void main(String[] args) {
        lc5711 obj=new lc5711();
        int n=6, index=2, maxSum=931384943;
        System.out.println(obj.maxValue(n, index, maxSum));
    }
}
