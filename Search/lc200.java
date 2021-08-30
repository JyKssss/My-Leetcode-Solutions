package Search;

public class lc200 {
    public int numIslands(char[][] grid) {
        int islandsCount=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    islandsCount++;
                    label(grid, i, j);
                }
            }
        }
        return islandsCount;
    }
    private void label(char[][] grid, int r,int c){
        int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        grid[r][c]+=1;
        for (int[] direction : directions) {
            int rNew=r+direction[0],cNew=c+direction[1];
            if (rNew>=0&&rNew< grid.length&& cNew>=0 && cNew<grid[0].length){
                if (grid[rNew][cNew]=='1'){
                    label(grid, rNew, cNew);
                }
            }
        }
    }
}
