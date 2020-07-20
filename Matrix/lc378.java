package Matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc378 {
    /**
     * 用值来进行二分查找 以往都是用角标
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int left=matrix[0][0];
        int right=matrix[matrix.length-1][matrix.length-1];
        while (left<right){
            int mid=left+((right-left)>>1);
            if (check(matrix, k, mid)){
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
    public boolean check(int[][]matrix,int k,int target){
        int v=matrix.length-1,h=0,count=0;
        while (v>=0&&h<matrix.length){
            if (matrix[v][h]<=target){
                h++;
                count+=(v+1);
            }
            else v--;
        }
        return count>=k;
    }
    /**
     * 用堆来解决问题
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new int[]{matrix[i][0],i,0});
        }
        int cur=0;
        for (int i = 0; i < k; i++) {
            int[] arr=pq.poll();
            cur=arr[0];
            if (arr[2]<matrix.length-1){
                pq.offer(new int[]{matrix[arr[1]][arr[2]+1],arr[1],arr[2]+1});
            }

        }
        return cur;
    }
}
