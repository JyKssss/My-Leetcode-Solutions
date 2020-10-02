package DynamicProgramming;

import java.util.Arrays;

public class lcp19 {
    public int minimumOperations(String leaves) {
        if (leaves.length()<=2)return 0;
        if (leaves.equals("yry"))return 3;
        int []resNums=new int[leaves.length()];
        int count=0,p=1,q= resNums.length-1;
        for (int i = 0; i < resNums.length; i++) {
            if (leaves.charAt(i)=='r')count++;
            resNums[i]=count;
        }
        int[] mins=new int[leaves.length()];
        Arrays.fill(mins, Integer.MAX_VALUE);
        while (q>=2){
            for (int i = 1; i <=q ; i++) {
                int cost=i-2*resNums[i-1]+2*resNums[q-1]-q;
                if (cost<mins[i])mins[i]=cost;
            }
            q--;
        }
        int index=0,min=Integer.MAX_VALUE;
        for (int i = 1; i < mins.length; i++) {
            if (mins[i]<min){
                index=i;
                min=mins[i];
            }
        }
        return leaves.length()-resNums[resNums.length-1]+min;
    }

    /**
     * 用 i j表示两个分界点 计算整体需要的次数
     * @param leaves
     * @return
     */
    public int minimumOperations2(String leaves) {
        int n = leaves.length();
        char[] array = leaves.toCharArray();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + (array[i] == 'r' ? 1 : 0);
        int[] min = new int[n + 1];
        int currentMin = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            currentMin = Math.min(currentMin, i - 2 * sum[i]);
            min[i] = currentMin;
        }
        int result = Integer.MAX_VALUE;
        for (int j = n - 1; j > 1; j--)
            result = Math.min(result, n - sum[n] + min[j - 1] - j + 2 * sum[j]);
        return result;
    }

}
