package Array;

public class lc275 {
    public int hIndex(int[] citations) {
        int start=0,end=citations.length-1,mid=(start+end)/2,res=0,total=citations.length;
        while (start<=end){
            mid=(start+end)/2;
            if (total-mid<=citations[mid]){
                end=mid-1;
                res=total-mid;
            }
            else {
                start=mid+1;
            }
        }
        return res;
    }
}
