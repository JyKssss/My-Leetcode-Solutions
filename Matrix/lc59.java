package Matrix;

public class lc59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int numLayer=(n+1)/2,num=1;
        for (int layer = 0; layer < numLayer; layer++) {
            //遍历上部
            for (int i = layer; i <n-layer ; i++) {
                matrix[layer][i]=num;
                num++;
            }
            //遍历右部
            for (int i = layer+1; i <n-layer ; i++) {
                matrix[i][n-1-layer]=num;
                num++;
            }
            //遍历下部
            for (int i = n-1-layer-1; i >=layer && n-1-layer!=layer ; i--) {
                matrix[n-1-layer][i]=num;
                num++;
            }
            //遍历左部
            for (int i = n-1-layer-1; i >layer && layer!=n-1-layer ; i--) {
                matrix[i][layer]=num;
                num++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        lc59 l=new lc59();
        l.generateMatrix(3);
    }
}
