package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class lc255 {
    public boolean verifyPreorder(int[] preorder) {
        List<Integer> list = new ArrayList<>();
        for (int p : preorder) {
            list.add(p);
        }
        return isPreorderHelper(list);
    }

    private boolean isPreorderHelper(List<Integer> list) {
        if (list == null || list.size() == 0){
            return true;
        }
        int pivot = list.get(0), index = 1;

        List<Integer> lList, rList;
        while (index < list.size() && list.get(index) < pivot){
            index ++;
        }
        lList = list.subList(1, index);
        rList = list.subList(index, list.size());
        for (Integer r : rList) {
            if (r < pivot){
                return false;
            }
        }

        if (isPreorderHelper(lList) && isPreorderHelper(rList)){
            return true;
        }
        return false;
    }

    public boolean verifyPreorder2(int[] preorder) {
        Deque<Integer> stack = new LinkedList<>();
        int preElement = Integer.MIN_VALUE;

        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < preElement){
                return false;
            }

            while (!stack.isEmpty() && stack.peekFirst() < preorder[i]) {
                preElement = stack.pollFirst();
            }
            stack.addFirst(preorder[i]);
        }
        return true;
    }
}
