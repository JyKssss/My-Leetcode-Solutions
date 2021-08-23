package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int target=transformer(label);
        List<Integer>list=new ArrayList<>(),res;
        while (target>0){
            list.add(target);
            target/=2;
        }
        Collections.reverse(list);
        res=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(transformer(list.get(i)));
        }
        return res;
    }

    private int transformer(int label){
        int height= (int) (Math.log(label)/Math.log(2))+1,rank=label-(int) Math.pow(2, height-1)+1;
        if ((height&1)==1){
            return label;
        }
        else {
            return (int) (Math.pow(2, height))-rank;
        }
    }
}
