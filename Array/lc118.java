package Array;

import java.util.ArrayList;
import java.util.List;

public class lc118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 1; i <=numRows ; i++) {
            List<Integer>line=new ArrayList<>();
            for (int j = 1; j <=i ; j++) {
                if (j==1||j==i)line.add(1);
                else {
                    line.add(res.get(res.size()-1).get(j-1)+res.get(res.size()-1).get(j-2));
                }
            }
            res.add(line);
        }
        return res;
    }
}
