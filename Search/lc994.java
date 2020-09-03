package Search;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class lc994 {
    public int orangesRotting(int[][] grid) {
        int freshCount=0,time=-1;
        Deque<Pair<Integer,Integer>>rotList=new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1)freshCount++;
                else if (grid[i][j]==2)rotList.addLast(new Pair<>(i, j));
            }
        }
        if (freshCount==0)return 0;
        while (!rotList.isEmpty()){
            int length=rotList.size();
            for (int i = 0; i < length; i++) {
                Pair<Integer,Integer>index=rotList.pollFirst();
                int x=index.getKey(), y=index.getValue();
                if (x+1<grid.length&&grid[x+1][y]==1){
                    rotList.addLast(new Pair<>(x+1, y));
                    grid[x+1][y]=2;
                    freshCount--;
                }
                if (x-1>=0&&grid[x-1][y]==1){
                    rotList.addLast(new Pair<>(x-1, y));
                    grid[x-1][y]=2;
                    freshCount--;
                }
                if (y+1<grid[0].length&&grid[x][y+1]==1){
                    rotList.addLast(new Pair<>(x, y+1));
                    grid[x][y+1]=2;
                    freshCount--;
                }
                if (y-1>=0&&grid[x][y-1]==1){
                    rotList.addLast(new Pair<>(x, y-1));
                    grid[x][y-1]=2;
                    freshCount--;
                }
            }
            time++;
        }
        if (freshCount>0)return -1;
        else return time;
    }

}
