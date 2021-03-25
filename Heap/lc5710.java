package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc5710 {
    /**
     * 销售订单价格<= 采购订单价格 匹配
     * 采购订单  大根堆  最大值
     * 销售订单  小根堆  最小值
     * 0 价格 1 数量  2 种类
     * @param orders
     * @return
     */
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]>buyOrders=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        PriorityQueue<int[]>sellOrders=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int[] order:orders){
            if (order[2]==0){
                int amount=order[1], price=order[0];
                while (!sellOrders.isEmpty()&&sellOrders.peek()[0]<=price&&amount>0){
                    if (sellOrders.peek()[1]>amount){
                        sellOrders.peek()[1]=sellOrders.peek()[1]-amount;
                        amount=0;
                    }
                    else {
                        amount-=sellOrders.poll()[1];
                    }
                }
                if (amount>0){
                    buyOrders.offer(new int[]{price,amount});
                }
            }
            else {
                int amount=order[1], price=order[0];
                while (!buyOrders.isEmpty()&&buyOrders.peek()[0]>=price&&amount>0){
                    if (buyOrders.peek()[1]>amount){
                        buyOrders.peek()[1]-=amount;
                        amount=0;
                    }
                    else {
                        amount-=buyOrders.poll()[1];
                    }

                }
                if (amount>0){
                    sellOrders.offer(new int[]{price,amount});
                }
            }
        }
        long size=0, mod= (long) (Math.pow(10, 9)+7);
        while (!sellOrders.isEmpty()){
            size+=sellOrders.poll()[1];
            size%=mod;
        }
        while (!buyOrders.isEmpty()){
            size+=buyOrders.poll()[1];
            size%=mod;
        }
        return (int) size;
    }

    public static void main(String[] args) {
        lc5710 obj=new lc5710();
        int[][] orders= new int[][]{{10,5,0},{15,2,1},{25,1,1},{30,4,0}};
        System.out.println(obj.getNumberOfBacklogOrders(orders));
    }
}
