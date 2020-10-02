package Matrix;

public class lc289 {
    /**
     * 可以使用复合状态 2表示之前死现在活 3表示之前活现在死
     * @param board
     */
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count=countLive(board, i, j);
                if (board[i][j]==1){
                    if(count<2||count>3)board[i][j]=3;
                }
                else {
                    if (count==3)board[i][j]=2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]==2)board[i][j]=1;
                else if (board[i][j]==3)board[i][j]=0;
            }
        }
    }
    public int countLive(int[][] board,int x,int y){
        int count=0,xLen= board.length,yLen=board[0].length;
        if(x-1>=0&&(board[x-1][y]==1||board[x-1][y]==3))count++;
        if(x-1>=0&&y-1>=0&&(board[x-1][y-1]==1||board[x-1][y-1]==3))count++;
        if(y-1>=0&&(board[x][y-1]==1||board[x][y-1]==3))count++;
        if (x+1<xLen&&(board[x+1][y]==1||board[x+1][y]==3))count++;
        if (x+1<xLen&&y+1<yLen&&(board[x+1][y+1]==1||board[x+1][y+1]==3))count++;
        if (y+1<yLen&&(board[x][y+1]==1||board[x][y+1]==3))count++;
        if (x+1<xLen&&y-1>=0&&(board[x+1][y-1]==1||board[x+1][y-1]==3))count++;
        if (x-1>=0&&y+1<yLen&&(board[x-1][y+1]==1||board[x-1][y+1]==3))count++;
        return count;
    }

}
