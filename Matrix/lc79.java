package Matrix;

/**
 * dfs方法 visited矩阵记录该点是否被访问 沿着上下左右方向进行递归并进行剪枝
 */
public class lc79 {
    boolean[][] visited;
    int lenx,leny;
    public boolean exist(char[][] board, String word) {
        if (board==null||board.length==0||board[0].length==0)return false;
        leny=board.length;
        lenx=board[0].length;
        visited=new boolean[leny][lenx];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(word, board, j, i, 0))return true;
            }
        }
        return false;
    }

    public boolean dfs(String word, char[][] borad,int x, int y, int index){
        if (borad[y][x]==word.charAt(index)){
            if (index==word.length()-1)return true;
            else {
                boolean left=false,right=false,up=false,down=false;
                visited[y][x]=true;
                if (x-1>=0&&visited[y][x-1]==false){
                    left=dfs(word, borad, x-1, y, index+1);
                }
                if (!left&&x+1<lenx&&visited[y][x+1]==false){
                    right=dfs(word, borad, x+1, y, index+1);
                }
                if (!right&&!left&&y-1>=0&&visited[y-1][x]==false){
                    down=dfs(word, borad, x, y-1, index+1);
                }
                if (!down&&!right&&!left&&y+1<leny&&visited[y+1][x]==false){
                    up=dfs(word, borad, x, y+1, index+1);
                }
                visited[y][x]=false;
                return left||right||down||up;
            }
        }
        else return false;
    }
}
