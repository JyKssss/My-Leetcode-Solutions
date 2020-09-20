package Search;

public class lc37 {
    public void solveSudoku(char[][] board) {
        //记录每行每列以及每个区块 1-9这9个数是否存在
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] block=new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.'){
                    row[i][board[i][j]-'0'-1]=true;
                    col[j][board[i][j]-'0'-1]=true;
                    int block_id=(i/3)*3+j/3;
                    block[block_id][board[i][j]-'0'-1]=true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);
    }

    public boolean dfs(char[][] board,boolean[][] row,boolean[][] col,boolean[][] block,int i, int j){
        //寻找空格
        while (board[i][j]!='.'){
            if (j<8)j++;
            else {
                if (i<8){
                    i++;
                    j=0;
                }
                else return true;
            }
        }
        int block_id=(i/3)*3+j/3;
        for (int k = 1; k <=9 ; k++) {
            if (!row[i][k-1]&&!col[j][k-1]&&!block[block_id][k-1]){
                row[i][k-1]=true;
                col[j][k-1]=true;
                block[block_id][k-1]=true;
                board[i][j]= (char) (k+'0');
                if (dfs(board, row, col, block, i, j))return true;
                else {
                    row[i][k-1]=false;
                    col[j][k-1]=false;
                    block[block_id][k-1]=false;
                    board[i][j]= '.';
                }
            }
        }
        return false;
    }
}
