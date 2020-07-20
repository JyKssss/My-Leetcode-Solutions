package Array;

public class lc419 {
    public int countBattleships(char[][] board) {
        int numOfShips=0;
        int xLength=board.length;
        int ylength=board[0].length;
        for (int x = 0; x <xLength ; x++) {
            for (int y = 0; y < ylength; y++) {
                if (board[x][y]=='.')continue;
                else {
                    if (x>0&&y>0&&board[x-1][y]=='.'&& board[x][y-1]=='.'){
                        numOfShips++;
                    }
                    else if (x>0&&y==0&&board[x-1][y]=='.'){
                        numOfShips++;
                    }
                    else if (x==0&&y>0&&board[x][y-1]=='.'){
                        numOfShips++;
                    }
                    else if (x==0&&y==0){
                        numOfShips++;
                    }
                }
            }
        }
        return numOfShips;
    }
}
