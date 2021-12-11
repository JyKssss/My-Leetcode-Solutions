package List;

import java.util.HashMap;
import java.util.List;

public class lc364 {
    int maxDepth = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        HashMap<Integer, Integer> depthSumMap = new HashMap<>();
        dfs(depthSumMap, 1, nestedList);
        int sum = 0;
        for (int i = 1; i <= maxDepth ; i++) {
            sum += (maxDepth - i + 1) * depthSumMap.getOrDefault(i, 0);
        }
        return sum;
    }

    private void dfs(HashMap<Integer, Integer> depthSumMap, int depth, List<NestedInteger> nestedList){
        maxDepth = Math.max(maxDepth, depth);
        for (NestedInteger nestedObj : nestedList) {
            if (nestedObj.isInteger()) {
                depthSumMap.put(depth, depthSumMap.getOrDefault(
                        depth, 0) + nestedObj.getInteger());
            } else {
                dfs(depthSumMap, depth + 1, nestedObj.getList());
            }
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    private interface NestedInteger {
        // Constructor initializes an empty nested list.


        // Constructor initializes a single integer.



        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}




