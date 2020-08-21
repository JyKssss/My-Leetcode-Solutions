package SystemDesign;

public class lc529 {
    boolean [][] isDiscover;
    int lenx=0,leny=0;
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board==null||board.length==0||board[0].length==0)return board;
        this.lenx=board.length;
        this.leny=board[0].length;
        this.isDiscover=new boolean[lenx][leny];
        dfs(board, click[0],click[1]);
        return board;
    }

    public void dfs(char[][] board,int x, int y){
        if (board[x][y]=='M'){
            board[x][y]='X';
            return;
        }
        else {
            int count=0;
            if (x+1<lenx&&board[x+1][y]=='M')count++;
            if (x-1>=0&&board[x-1][y]=='M')count++;
            if (y+1<leny&&board[x][y+1]=='M')count++;
            if (y-1>=0&&board[x][y-1]=='M')count++;
            if (x+1<lenx&&y+1<leny&&board[x+1][y+1]=='M')count++;
            if (x+1<lenx&&y-1>=0&&board[x+1][y-1]=='M')count++;
            if (x-1>=0&&y+1<leny&&board[x-1][y+1]=='M')count++;
            if (x-1>=0&&y-1>=0&&board[x-1][y-1]=='M')count++;
            if (count>0){
                board[x][y]= (char) ('0'+count);
                isDiscover[x][y]=true;
            }
            else {
                board[x][y]='B';
                isDiscover[x][y]=true;
                if (x+1<lenx&&isDiscover[x+1][y]==false)dfs(board, x+1, y);
                if (y+1<lenx&&isDiscover[x][y+1]==false)dfs(board, x, y+1);
                if (x-1>=0&&isDiscover[x-1][y]==false)dfs(board, x-1, y);
                if (y-1>=0&&isDiscover[x][y-1]==false)dfs(board, x, y-1);
                if (x+1<lenx&&y+1<leny&&isDiscover[x+1][y+1]==false)dfs(board, x+1, y+1);
                if (x+1<lenx&&y-1>=0&&isDiscover[x+1][y-1]==false)dfs(board, x+1, y-1);
                if (x-1>=0&&y+1<leny&&isDiscover[x-1][y+1]==false)dfs(board, x-1, y+1);
                if (x-1>=0&&y-1>=0&&isDiscover[x-1][y-1]==false)dfs(board, x-1, y-1);
            }
        }
    }
}
