package Array;

public class lc1011 {
    public int shipWithinDays(int[] weights, int D) {
        int maxWeight=0,minWeight=0,res=Integer.MAX_VALUE;
        for (int i = 0; i < weights.length; i++) {
            maxWeight+=weights[i];
            minWeight=minWeight<weights[i]?weights[i]:minWeight;//单件货物的最大值
        }
        while (minWeight<=maxWeight){
            int midW=(minWeight+maxWeight)/2;
            System.out.println(midW);
            int index=0;
            boolean canAfford=false;
            //模拟每天的载货
            for (int i = 0; i < D; i++) {
                int curWeight=0;
                //加到满载
                while (curWeight<=midW){
                    if (index<weights.length&&curWeight+weights[index]<=midW){
                        curWeight+=weights[index];
                        index++;
                    }
                    else if (index>=weights.length){
                        canAfford=true;
                        break;
                    }
                    else if (curWeight+weights[index]>midW){
                        break;
                    }
                }
                if (canAfford==true)break;
            }
            if (index==weights.length){
                System.out.println("afford "+midW);
                res=Math.min(midW, res);
                maxWeight=midW-1;
            }
            else {
                minWeight=midW+1;
            }

        }
        return res;
    }
}
