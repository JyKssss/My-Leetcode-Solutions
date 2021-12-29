package Array;

import java.util.Stack;

public class lc723 {
    public int[][] candyCrush(int[][] board) {
        boolean isCrushed = false;
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c - 2; j++) {
                int absValue = Math.abs(board[i][j]);
                boolean isSame = true;
                for (int k = j; k < j + 3; k++) {
                    if (Math.abs(board[i][k]) != absValue || board[i][k] == 0) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int k = j; k < j + 3; k++) {
                        board[i][k] = -absValue;
                    }
                    isCrushed = true;
                }
            }
        }

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r - 2; j++) {
                int absValue = Math.abs(board[j][i]);
                boolean isSame = true;
                for (int k = j; k < j + 3; k++) {
                    if (Math.abs(board[k][i]) != absValue || board[k][i] == 0) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int k = j; k < j + 3; k++) {
                        board[k][i] = -absValue;
                    }
                    isCrushed = true;
                }
            }
        }

        if (isCrushed) {
            int[][] newBoard = new int[r][c];
            for (int i = 0; i < c; i++) {
                Stack<Integer> stack = new Stack<>();
                for (int j = 0; j < r; j += 1) {
                    if (board[j][i] > 0) {
                        stack.push(board[j][i]);
                    }
                }
                int index = r - 1;
                while (!stack.empty()) {
                    newBoard[index][i] = stack.pop();
                    index -= 1;
                }
            }
            board = newBoard;
        }
        if (isCrushed) {
            return candyCrush(board);
        } else {
            return board;
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{1,3,5,5,2},{3,4,3,3,1},{3,2,4,5,2},{2,4,4,5,5},{1,4,4,1,1}};
        lc723 obj = new lc723();
        System.out.println(obj.candyCrush(board));
    }
}
