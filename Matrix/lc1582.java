package Matrix;

public class lc1582 {
    public int numSpecial(int[][] mat) {
        int total=0;
        for (int i = 0; i < mat.length; i++) {
            int count=0,index=0;
            for (int j = 0; j <mat[i].length; j++) {
                if (mat[i][j]==1){
                    count++;
                    index=j;
                }
            }
            if (count==1){
                int count2=0;
                for (int j = 0; j < mat.length; j++) {
                    if (mat[j][index]==1)count2++;
                }
                if (count2==1)total++;
            }
        }
        return total;
    }
}
