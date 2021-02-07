package Array;

public class lc1423 {
    public int maxScore(int[] cardPoints, int k) {
        int left=0,right=0,minScore=Integer.MAX_VALUE,score=0,len= cardPoints.length-k,lenArray= cardPoints.length,total=0;
        for(int p: cardPoints)total+=p;
        for (right = 0; right <len ; right++) {
            score+=cardPoints[right];
        }
        minScore=Math.min(minScore, score);
        while (right<lenArray){
            if (right==len-1){
                left++;
                right++;
                continue;
            }
            score-=cardPoints[left];
            score+=cardPoints[right];
            minScore=Math.min(minScore, score);
            right++;
            left++;
        }
        return total-minScore;
    }
}
