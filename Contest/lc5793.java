package Contest;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class lc5793 {
    // . 路 + 墙
    public int nearestExit(char[][] maze, int[] entrance) {
        int xLen= maze.length-1,yLen=maze[0].length-1, step=0,size;
        HashSet<String>visitedSet=new HashSet<>();
        Deque<int[]>line=new LinkedList<>();
        line.addLast(entrance);
        visitedSet.add(entrance[0]+"_"+entrance[1]);
        while (!line.isEmpty()){
            size=line.size();
            for (int i = 0; i < size; i++) {
                int[] node=line.pollFirst();
                int x=node[0],y=node[1];
                if ((x==0||x==xLen||y==0||y==yLen) && !(x==entrance[0]&&y==entrance[1])){
                    return step;
                }
                int[] up=new int[]{x+1,y},down=new int[]{x-1,y},left=new int[]{x,y-1},right=new int[]{x,y+1};
                String upStr=up[0]+"_"+up[1],downStr=down[0]+"_"+down[1],leftStr=left[0]+"_"+left[1],rightStr=right[0]+"_"+right[1];
                if (x-1>=0 && maze[x-1][y]=='.' && !visitedSet.contains(downStr)){
                    visitedSet.add(downStr);
                    line.addLast(down);
                }
                if (y-1>=0 && maze[x][y-1]=='.' && !visitedSet.contains(leftStr)){
                    visitedSet.add(leftStr);
                    line.addLast(left);
                }
                if (x+1<=xLen && maze[x+1][y]=='.' && !visitedSet.contains(upStr)){
                    visitedSet.add(upStr);
                    line.addLast(up);
                }
                if (y+1<=yLen && maze[x][y+1]=='.' && !visitedSet.contains(rightStr)){
                    visitedSet.add(rightStr);
                    line.addLast(right);
                }
                System.out.println("Step : "+step +" Cur : " + x +" "+y);

            }
            step++;
        }

        return -1;
    }
}
