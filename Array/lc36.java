package Array;

public class lc36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rowCnt = new int[9][10];
        int[][] colCnt = new int[9][10];
        int[][] sqrCnt = new int[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowCnt[i][num] += 1;
                    colCnt[j][num] += 1;
                    sqrCnt[(i / 3) * 3 + j /3][num] += 1;
                    if (rowCnt[i][num] > 1 || colCnt[j][num] >1 || sqrCnt[(i / 3) * 3 + j /3][num] >1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
