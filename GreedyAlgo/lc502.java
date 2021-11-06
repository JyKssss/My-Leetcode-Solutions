package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][]captialProfitsList=new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            captialProfitsList[i][0]=capital[i];
            captialProfitsList[i][1]=profits[i];
        }
        int indexWork=0,indexProj=0;
        Arrays.sort(captialProfitsList, (o1, o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]>projHeap=new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);

        while (indexWork<k){
            while (indexProj<captialProfitsList.length && captialProfitsList[indexProj][0]<=w){
                projHeap.offer(captialProfitsList[indexProj]);
                indexProj+=1;
            }
            if (projHeap.size()==0){
                break;
            }
            int[] maxProfitProj=projHeap.poll();
            w+=maxProfitProj[1];
            indexWork++;
        }
        return w;
    }
}
