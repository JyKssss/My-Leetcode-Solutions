package Graph;

import java.util.*;

public class lc51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res=new ArrayList<>();
        Set<Integer>columns=new HashSet<>();
        Set<Integer>diagonal1=new HashSet<>();
        Set<Integer>diagonal2=new HashSet<>();
        int[] queens=new int[n];
        Arrays.fill(queens, -1);
        backTrack(res,columns, diagonal1, diagonal2, 0, n, queens);
        return res;
    }

    public void backTrack(List<List<String>>result,Set<Integer>columns,Set<Integer>diagonal1,Set<Integer>diagonal2,int row,int n,int[]queens){
        if (row==n){
            List<String>solution=generateSolution(queens);
            result.add(solution);
        }else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i))continue;
                int d1=row+i;
                if (diagonal1.contains(d1))continue;
                int d2=row-i;
                if (diagonal2.contains(d2))continue;
                columns.add(i);
                diagonal1.add(d1);
                diagonal2.add(d2);
                queens[row]=i;
                backTrack(result,columns, diagonal1, diagonal2, row+1, n, queens);
                queens[row]=-1;
                columns.remove(i);
                diagonal1.remove(d1);
                diagonal2.remove(d2);
            }
        }
    }

    public List<String> generateSolution(int[]queens){
        List<String>solution=new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            char[] chars=new char[queens.length];
            Arrays.fill(chars, '.');
            chars[queens[i]]='Q';
            solution.add(String.valueOf(chars));
        }
        return solution;
    }
}
