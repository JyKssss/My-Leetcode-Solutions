package Graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class lc789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        HashSet<String>ghostSet=new HashSet<>();
        HashSet<String>visited=new HashSet<>();
        int min=-10000,max=10000,size,x,y;
        for (int[] ghost : ghosts) {
            ghostSet.add(ghost[0]+"_"+ghost[1]);
        }
        int[][]directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Deque<int[]>list= new LinkedList<>();
        list.addLast(target);
        visited.add(target[0]+"_"+target[1]);
        if (target[0]==0&&target[1]==0){
            if (ghostSet.contains(0+"_"+0)){
                return false;
            }
            else {
                return true;
            }
        }
        while (list.size()>0){
            size=list.size();
            boolean zero=false;
            for (int i = 0; i < size; i++) {
                int[]cur=list.pollFirst();
                for (int[] direction : directions) {
                    x=cur[0]+direction[0];
                    y=cur[1]+direction[1];
                    if (x<min||x>max||y<min||y>max){
                        continue;
                    }
                    String next=x+"_"+y;
                    if (!visited.contains(next)){
                        if (ghostSet.contains(next)){
                            return false;
                        }
                        else {
                            visited.add(next);
                            list.addLast(new int[]{x,y});
                        }
                        if (x==0&&y==0){
                            zero=true;
                        }
                    }
                }
            }
            if (zero==true){
                return true;
            }
        }
        return false;
    }


    //曼哈顿距离
    public boolean escapeGhosts2(int[][] ghosts, int[] target) {
        int dis=Math.abs(target[0])+Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int curDis=Math.abs(ghost[0]-target[0])+Math.abs(ghost[1]-target[1]);
            if (curDis<=dis){
                return false;
            }
        }
        return true;
    }
}
