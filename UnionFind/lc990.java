package UnionFind;

import java.util.HashMap;

/**
 * 标准并查集解决方案
 */
public class lc990 {
    HashMap<Character,Character>UF;
    public boolean equationsPossible(String[] equations) {
        UF=new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            char left=equations[i].charAt(0),right=equations[i].charAt(3);
            if (!UF.containsKey(left))UF.put(left, left);
            if (!UF.containsKey(right))UF.put(right, right);
            if (equations[i].charAt(1)=='='){
                merge(left, right);
            }
        }
        for (int i = 0; i < equations.length; i++) {

            if (equations[i].charAt(1)=='!'){
                char left=equations[i].charAt(0),right=equations[i].charAt(3);
                if (find(left)==find(right))return false;
            }
        }
        return true;
    }
    public char find(char character){
        return character==UF.get(character)?character:find(UF.get(character));
    }
    public void merge(char c1,char c2){
        UF.replace(find(c2), find(c1));
    }
}
