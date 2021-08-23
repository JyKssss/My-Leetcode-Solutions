package Contest;

public class lc5794 {
    public boolean sumGame(String num) {
        int diff=0,leftCnt=0,rightCnt=0,len=num.length(),leftSum=0,rightSum=0,max,maxAlice;
        for (int i = 0; i < len/2; i++) {
            if (num.charAt(i)=='?'){
                leftCnt++;
            }
            else{
                leftSum+=num.charAt(i)-'0';
            }
        }

        for (int i = len/2; i <len ; i++) {
            if (num.charAt(i)=='?'){
                rightCnt++;
            }
            else{
                rightSum+=num.charAt(i)-'0';
            }
        }
        System.out.println(leftSum+" "+rightSum);
        diff=leftSum-rightSum;
        if (leftCnt-rightCnt%2==1){
            return true;
        }
        max=((leftCnt-rightCnt)/2)*9;
        if (diff+max==0 &&diff!=0){
            return false;
        }
        else {
            return true;
        }

    }
}
