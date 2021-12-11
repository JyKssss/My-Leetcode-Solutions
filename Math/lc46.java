package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        for (int num : nums) {
            permutation.add(num);
        }
        backtrack(res, permutation, 0, nums.length);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> permutation, int index, int len) {
        if (index == len) {
            res.add(new ArrayList<>(permutation));
        } else {
            for (int i = index; i < len; i++) {
                Collections.swap(permutation, i, index);
                backtrack(res, permutation, index + 1, len);
                Collections.swap(permutation, i, index);
            }
        }
    }
}
