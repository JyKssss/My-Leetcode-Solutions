package Array;

public class lc978 {
    public int maxTurbulenceSize(int[] arr) {
        int left=0,right=0,len=arr.length,maxLen=len>=1?1:0,curLen;
        boolean nextLarger=true;
        while (left<len-1&&right<len){
            if (left==right){
                if (arr[left]>arr[left+1]){
                    right++;
                    nextLarger=false;
                }
                else if (arr[left]<arr[left+1]){
                    right++;
                    nextLarger=true;
                }
                else {
                    left++;
                    right++;
                }
                curLen=right-left+1;
            }
            else {
                if (right<len-1&&arr[right]>arr[right+1]&&nextLarger){
                    right++;
                    nextLarger=false;
                }
                else if (right<len-1&&arr[right]<arr[right+1]&&!nextLarger){
                    right++;
                    nextLarger=true;
                }
                else if (right==len-1)break;
                else {
                    left=right;
                }
                curLen=right-left+1;
            }
            maxLen=Math.max(curLen, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        lc978 obj=new lc978();
        int[] arr=new int[]{0,1,1,0,1,0,1,1,0,0};
        System.out.println(obj.maxTurbulenceSize(arr));
    }
}
