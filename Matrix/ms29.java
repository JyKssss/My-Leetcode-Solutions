package Matrix;

import java.util.ArrayList;
import java.util.List;

public class ms29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null||matrix.length==0)return new int[0];
        int numLayer=(Math.min(matrix.length, matrix[0].length)+1)/2,xLen=matrix[0].length,yLen=matrix.length;
        List<Integer> res=new ArrayList<>();
        for (int layer = 0; layer < numLayer; layer++) {
            //遍历上部
            for (int i = layer; i <xLen-layer ; i++) {
                res.add(matrix[layer][i]);
                // System.out.println(matrix[layer][i]);
            }
            //遍历右部
            for (int i = layer+1; i <yLen-layer ; i++) {
                // System.out.println("y "+i);
                res.add(matrix[i][xLen-1-layer]);
                // System.out.println(matrix[i][xLen-1-layer]);
            }
            //遍历下部
            for (int i = xLen-layer-2; i >=layer &&yLen-layer-1!=layer ; i--) {
                res.add(matrix[yLen-1-layer][i]);
            }
            //遍历左部
            for (int i = yLen-1-layer-1; i >layer && layer!=xLen-1-layer; i--) {
                res.add(matrix[i][layer]);
            }
        }
        int[] result=new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i]=res.get(i);
        }
        return result;
    }
}
