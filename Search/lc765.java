package Search;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc765 {
    /**
     * #1 广度优先搜索
     * #2 并查集
     *
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        int[] map=new int[row.length];
        boolean[] isVisited=new boolean[row.length];
        int res=0;
        for (int i = 0; i < row.length; i++) {
            map[row[i]]=i;
        }
        Arrays.fill(isVisited, false);

        for (int i = 0; i < row.length; i+=2) {
            if (isVisited[i])continue;
            else {
                Queue<Integer> queue=new LinkedList<>();
                isVisited[i]=true;
                isVisited[i+1]=true;
                queue.offer(i);
                int cnt=0;

                while (!queue.isEmpty()){
                    int x=queue.poll(),y=x^1,indexY=map[y],IndexZ=indexY^1;
                    if (isVisited[indexY])break;
                    cnt++;

                }
            }
        }
        return res;
    }




    public void swap(int[] nums, int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
        return;
    }
}

class unionSolu{
    int [] couples;
    public int find(int x){
        if (couples[x]!=x)couples[x]=find(couples[x]);
        return couples[x];
    }

    public void union(int x, int y){
        couples[find(y)]=couples[find(x)];
    }
    public int minSwapsCouples(int @NotNull [] row) {
        int size= row.length/2, headNum=0;
        couples=new int[size];
        for (int i = 0; i <size; i++) {
            couples[i]=i;
        }

        for (int i = 0; i < size*2; i+=2) {
            union(row[i]/2,row[i+1]/2 );
        }

        for (int i = 0; i < couples.length; i++) {
            if (couples[i]==i)headNum++;
        }

        return size-headNum;
    }

    public static void main(String[] args) {
        unionSolu obj=new unionSolu();
        int[] row=new int[]{5,4,2,6,3,1,0,7};
        obj.minSwapsCouples(row);
    }
}
