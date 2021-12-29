package Search;

public class lc419 {
    public int countBattleships(char[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    boolean isHead = true;
                    if (i - 1 >= 0 && board[i - 1][j] == 'X') {
                        isHead = false;
                    }
                    if (j - 1 >= 0 && board[i][j - 1] == 'X') {
                        isHead = false;
                    }
                    if (isHead) {
                        cnt += 1;
                    }
                }
            }
        }
        return cnt;
    }
}
