package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc331 {
    LinkedList<String>preorderList;
    public boolean isValidSerialization(String preorder) {
        this.preorderList=new LinkedList<>(Arrays.asList(preorder.split(",")));
        return serializationHeloerDfs()&& preorderList.isEmpty();
    }

    public boolean serializationHeloerDfs(){
        if (preorderList.isEmpty()){
            return false;
        }
        String cur=preorderList.pollFirst();
        if (cur.equals("#")){
            return true;
        }
        else {
            return serializationHeloerDfs()&&serializationHeloerDfs();
        }
    }
}
