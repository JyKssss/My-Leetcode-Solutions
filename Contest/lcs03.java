package Contest;

import java.util.Deque;
import java.util.LinkedList;

public class lcs03 {
    boolean[][] isVisited;
    int maxSqr;
    public int largestArea(String[] grid) {
        int xLen= grid.length,yLen=0;
        for (String s : grid) {
            yLen=Math.max(s.length(), yLen);
        }

        int[][] table=new int[xLen+2][yLen+2];
        for (int i = 0; i < xLen; i++) {
            String s=grid[i];
            for (int j = 0; j <s.length() ; j++) {
                table[i+1][j+1]=s.charAt(j)-'0';
            }
        }
        this.isVisited=new boolean[xLen+2][yLen+2];
        this.maxSqr=0;
        for (int i = 1; i <=xLen ; i++) {
            for (int j = 1; j <=yLen ; j++) {
                if (!isVisited[i][j]){
                    bfs(i, j, table);
                }
            }
        }
        return maxSqr;
    }

    private boolean bfs(int x, int y, int[][] table){
//        System.out.println(x+" , "+y);
        boolean isEdge=false;
        int square=0,target=table[x][y];
//        System.out.println("target : "+target);
        Deque<int[]>list=new LinkedList<>();
        list.add(new int[]{x,y});
        isVisited[x][y]=true;
        while (!list.isEmpty()){
            int[] point=list.pollFirst();
            square++;

            if (table[point[0]-1][point[1]]==0||table[point[0]+1][point[1]]==0||table[point[0]][point[1]-1]==0||table[point[0]][point[1]+1]==0){
                isEdge=true;
            }
//            System.out.println("point : "+point[0]+","+point[1]);
            if (table[point[0]-1][point[1]]==target && !isVisited[point[0]-1][point[1]] && table[point[0]-1][point[1]]!=0){
                list.add(new int[]{point[0]-1,point[1]});
                isVisited[point[0]-1][point[1]]=true;
            }
            if (table[point[0]+1][point[1]]==target && !isVisited[point[0]+1][point[1]] && table[point[0]+1][point[1]]!=0){
                list.add(new int[]{point[0]+1,point[1]});
                isVisited[point[0]+1][point[1]]=true;
            }
            if (table[point[0]][point[1]-1]==target && !isVisited[point[0]][point[1]-1] && table[point[0]][point[1]-1]!=0){
                list.add(new int[]{point[0],point[1]-1});
                isVisited[point[0]][point[1]-1]=true;
            }
            if (table[point[0]][point[1]+1]==target && !isVisited[point[0]][point[1]+1] && table[point[0]][point[1]+1]!=0){
                list.add(new int[]{point[0],point[1]+1});
                isVisited[point[0]][point[1]+1]=true;
            }
        }
        if (!isEdge){
            maxSqr=Math.max(maxSqr, square);
        }
        return isEdge;
    }

    public static void main(String[] args) {
        lcs03 obj=new lcs03();
        String[] strings=new String[]{"2545552502","5154301454","1331554113","3211125150","5311515515","2324502045","2551325553","2434242405"};
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(obj.largestArea(strings));
    }
}
