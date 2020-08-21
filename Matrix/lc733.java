package Matrix;

public class lc733 {
    boolean[][] isVisited;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image==null||image.length==0||image[0].length==0)return image;
        isVisited=new boolean[image.length][image[0].length];
        dfs(image, sr, sc, newColor);

        return image;
    }

    public void dfs(int[][] image,int r,int c,int newcolor){
        isVisited[r][c]=true;
        int originColor=image[r][c];
        int rMax=image.length-1, cMax=image[0].length-1;
        if (r+1<=rMax&&image[r+1][c]==originColor&&!isVisited[r+1][c])dfs(image, r+1, c, newcolor);
        if (c+1<=cMax&&image[r][c+1]==originColor&&!isVisited[r][c+1])dfs(image, r, c+1, newcolor);
        if (r-1>=0&&image[r-1][c]==originColor&&!isVisited[r-1][c])dfs(image, r-1, c, newcolor);
        if (c-1>=0&&image[r][c-1]==originColor&&!isVisited[r][c-1])dfs(image, r, c-1, newcolor);
        image[r][c]=newcolor;
        return;
    }
}
