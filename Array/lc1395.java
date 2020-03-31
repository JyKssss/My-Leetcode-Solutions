package Array;

/***
 * 将每个数作为士兵队伍里的中位数计算left*right 之后想加得到结果 时间复杂度On^2
 */
public class lc1395 {
    public int numTeams(int[] rating) {
        int groupNum=0;
        for (int i = 0; i < rating.length; i++) {
            int compare=rating[i];
            int leftSmall=findSmaller(rating, 0, i, compare);
            int rightBig=findBigger(rating, i, rating.length, compare);
            int leftBig=findBigger(rating, 0, i, compare);
            int rightSmall=findSmaller(rating, i, rating.length, compare);
            groupNum+=leftSmall*rightBig+leftBig*rightSmall;
        }
        return groupNum;
    }
    private static int findBigger(int[]rating,int start,int end,int compare){
        int biggerNum=0;
        for (int i = start; i < end; i++) {
            if (rating[i]>compare)biggerNum++;
        }
        return biggerNum;
    }
    private static int findSmaller(int[]rating,int start,int end,int compare){
        int smallerNum =0;
        for (int i = start; i < end; i++) {
            if (rating[i]<compare)smallerNum++;
        }
        return smallerNum;
    }
}
