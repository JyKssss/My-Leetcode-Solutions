package SystemDesign;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class lc341 {
    /**
     * 惰性迭代
     */
    public class NestedIterator implements Iterator<Integer> {
        LinkedList<NestedInteger>list;
        public NestedIterator(List<NestedInteger> nestedList) {
            this.list=new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return list.remove(0).getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!list.isEmpty() && !list.peekFirst().isInteger()){
                List<NestedInteger> cur=list.remove(0).getList();
                for (int i = cur.size()-1; i >=0 ; i--) {
                    list.addFirst(cur.get(i));
                }
            }
            return !list.isEmpty();
        }
    }

    /**
     *
     */

    public class NestedIterator2 implements Iterator<Integer> {
        Iterator<Integer>it;
        List<Integer>list;
        public NestedIterator2(List<NestedInteger> nestedList) {
            this.list=new LinkedList<>();
            flatten(nestedList);
            this.it=list.iterator();
        }

        public void flatten(List<NestedInteger> nestedList){
            for(NestedInteger nestedInteger:nestedList){
                if (nestedInteger.isInteger()){
                    list.add(nestedInteger.getInteger());
                }
                else {
                    flatten(nestedInteger.getList());
                }
            }
        }
        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Integer next() {
            return it.next();
        }
    }

    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}


