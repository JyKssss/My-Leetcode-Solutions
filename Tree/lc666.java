package Tree;

import java.util.HashMap;
import java.util.Map;

public class lc666 {
    int sum = 0;

    public int pathSum(int[] nums) {
        Map<Integer, Integer> nodeMap = new HashMap<>();
        for (int num : nums) {
            nodeMap.put(num / 10, num % 10);
        }
        recurse(nodeMap, nums[0] / 10, 0);
        return sum;
    }

    private void recurse(Map<Integer, Integer> nodeMap, int curNode, int pathSum) {
        int layer = curNode - curNode % 10;
        int position = curNode % 10;
        int left = layer + 10 + position * 2 - 1;
        int right = layer + 10 + position * 2;
//        System.out.println("Current Node : " + curNode);
        pathSum += nodeMap.get(curNode);
        if (!nodeMap.containsKey(left) && !nodeMap.containsKey(right)) {
            sum += pathSum;
            return;
        }
        if (nodeMap.containsKey(left)){
            recurse(nodeMap, left, pathSum);
        }
        if (nodeMap.containsKey(right)){
            recurse(nodeMap, right, pathSum);
        }
    }


    public static void main(String[] args) {
        lc666 obj = new lc666();
        System.out.println(obj.pathSum(new int[]{113,215,221}));
    }
}
