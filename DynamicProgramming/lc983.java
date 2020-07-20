package DynamicProgramming;

public class lc983 {
    /**
     * 计算旅行的最小花费
     * 使用DP解题的时候 将买票的方式改成最后一天记账的模式 第i天时计算 i-1加一天的费用 i-7加周票 i-30加月票 计算最小值
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int oneDayC=costs[0];
        int oneWeekC=costs[1];
        int oneMonthC=costs[2];
        if (oneWeekC<oneDayC&&oneMonthC>oneWeekC)oneDayC=oneWeekC;
        if (oneMonthC<oneDayC&&oneMonthC<oneWeekC){
            oneDayC=oneMonthC;
            oneWeekC=oneMonthC;
        }
        int[]dailyCosts=new int[366];
        int index=0;
        for (int i = 1; i <=365 ; i++) {
            if (index>=days.length)break;
            if (days[index]!=i)dailyCosts[i]=dailyCosts[i-1];
            else {
                index++;
                dailyCosts[i]=Math.min(Math.min(dailyCosts[i-1]+oneDayC,dailyCosts[Math.max(i-7, 0)]+oneWeekC ),
                        dailyCosts[Math.max(i-30, 0)]+oneMonthC);
            }
        }
        return dailyCosts[days[index-1]];
    }
}
