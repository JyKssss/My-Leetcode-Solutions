package Contest;

public class lc5845 {
    public int latestDayToCross(int row, int col, int[][] cells) {

        int start=0,end= cells.length-1,mid,days=0;
        while (start<=end){
            mid=start+(end-start)/2;
            int[][]map=new int[row][col];
            for (int i = 0; i <= mid; i++) {
                map[cells[i][0]-1][cells[i][1]-1]=1;
            }
            if (verify(map)){
                days=mid+1;
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }

//
//        for (int[] cell : cells) {
//            map[cell[0]-1][cell[1]-1]=1;
//            if (verify(map)){
//                days++;
//            }
//            else break;
//        }
        return days;
    }

    private boolean verify(int[][]map){
        int[][]memo=new int[map.length][map[0].length];

        for (int i = 0; i < map[0].length; i++) {
            int[][]visitedMap=new int[map.length][map[0].length];
            if (map[0][i]!=1&&dfs(map, memo, visitedMap, 0, i)){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[][]map,int[][]memo,int[][]visitedMap,int r,int c){
        int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int rMax=map.length-1,cMax=map[0].length-1;
        for (int[] direction : directions) {
            int nextR=r+direction[0],nextC=c+direction[1];
            if (nextR>=0&&nextR<=rMax&&nextC>=0&&nextC<=cMax){
                if (map[nextR][nextC]==1){
                    continue;
                }
                else {
                    if (nextR==rMax){
                        return true;
                    }
                    else if(visitedMap[nextR][nextC]==0&&memo[nextR][nextC]==0){
                        visitedMap[nextR][nextC]=1;
                        if (dfs(map, memo, visitedMap, nextR, nextC)){
                            return true;
                        }
                        else {
                            memo[nextR][nextC]=1;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        lc5845 obj=new lc5845();
        int row=4,col=3;
        int[][] cells=new int[][]{{3,2},{2,1},{1,3},{1,2},{3,3},{2,2},{4,3},{1,1},{2,3},{4,1},{3,1},{4,2}};
        System.out.println(obj.latestDayToCross(row, col, cells));
    }



}
