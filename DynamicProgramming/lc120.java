package DynamicProgramming;

import java.util.List;

public class lc120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int [] pre,cur;
        if (triangle==null||triangle.size()==0)return 0;
        pre=new int[]{triangle.get(0).get(0)};
        for (int i = 1; i <triangle.size() ; i++) {
            cur=new int[triangle.get(i).size()];
            for (int j = 0; j < cur.length; j++) {
                if (j==0)cur[j]=pre[0]+triangle.get(i).get(j);
                else if (j==cur.length-1)cur[j]=pre[j-1]+triangle.get(i).get(j);
                else cur[j]=Math.min(pre[j-1],pre[j])+triangle.get(i).get(j);
            }
            pre=cur;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <pre.length ; i++) {
            min=Math.min(min, pre[i]);
        }
        return min;
    }
}
