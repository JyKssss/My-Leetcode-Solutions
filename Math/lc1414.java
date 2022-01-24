package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc1414 {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        int fn;
        while (true) {
            fn = list.get(list.size() - 1) + list.get(list.size() - 2);
            if (fn > k) {
                break;
            }
            list.add(fn);
        }
        Collections.reverse(list);
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            if (cur <= k) {
                k -= cur;
                cnt += 1;
            }
            if (k == 0) break;
        }
        return cnt;
    }
}
