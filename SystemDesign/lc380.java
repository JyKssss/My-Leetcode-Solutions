package SystemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class lc380 {
    class RandomizedSet {
        HashMap<Integer,Integer>valIndexMap;
        List<Integer> list;
        Random random=new Random();
        /** Initialize your data structure here. */
        public RandomizedSet() {
            this.valIndexMap=new HashMap<>();
            this.list=new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (valIndexMap.containsKey(val)){
                return false;
            }
            else {
                valIndexMap.put(val, list.size());
                list.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!valIndexMap.containsKey(val)){
                return false;
            }
            int index=valIndexMap.get(val),tmp=list.get(list.size()-1);
            list.set(index, list.get(list.size()-1));
            list.remove(list.size()-1);
            valIndexMap.remove(val);
            valIndexMap.replace(tmp, index);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {

            int index= random.nextInt(list.size());
            return list.get(index);
        }
    }
}
