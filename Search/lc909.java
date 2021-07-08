package Search;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class lc909 {
    public int snakesAndLadders(int[][] board) {
        int Len= board.length,target=Len*Len,cur,time=0;
        Deque<Integer>queue=new LinkedList<>();
        HashSet<Integer>isVisited=new HashSet<>();
        queue.add(1);
        while (!queue.isEmpty()){

            int size= queue.size();
            for (int i = 0; i < size; i++) {
                cur=queue.pollFirst();
                if (cur==target){
                    return time;
                }
                for (int j = 1; j <=6; j++) {
                    if (cur+j>target){
                        break;
                    }
                    if (isVisited.contains(cur+j)){
                        continue;
                    }
                    isVisited.add(cur+j);
                    int[] index=calIndex(cur+j, Len);
                    if (board[index[0]][index[1]]!=-1&& !isVisited.contains(board[index[0]][index[1]])){
                        isVisited.add(board[index[0]][index[1]]);
                        queue.addLast(board[index[0]][index[1]]);
                    }
                    else if (board[index[0]][index[1]]!=-1&& isVisited.contains(board[index[0]][index[1]])){

                    }
                    else {
                        queue.addLast(cur+j);
                    }
                }
            }
            time++;
        }
        return -1;
    }

    private int[] calIndex(int n, int Len){
        int[] index=new int[2];
        int r=(n-1)/Len;
        index[0]=Len-1-r;
        index[1]=(r&1)==0?(n-1)%Len:(Len-1-(n-1)%Len);
        return index;
    }
}
