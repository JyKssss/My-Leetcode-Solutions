package Math;

import java.util.HashSet;

public class lc1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=1)return false;
        int[] start=coordinates[0];
        HashSet<Double>set=new HashSet<>();
        for (int i = 1; i <coordinates.length ; i++) {
            if (coordinates[i][0]-start[0]==0){
                set.add(Double.MAX_VALUE);
                continue;
            }
            double k=(double)(coordinates[i][1]-start[1])/(coordinates[i][0]- start[0]);
            System.out.println(k);
            set.add(k);
        }
        return set.size()==1;
    }
}
