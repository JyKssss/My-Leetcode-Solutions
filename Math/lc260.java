package Math;

import java.util.ArrayList;
import java.util.List;

public class lc260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int rightMostOne = 1;
        while ((rightMostOne & xor) == 0) {
            rightMostOne = rightMostOne << 1;
        }
        List<Integer> zeroList = new ArrayList<>();
        List<Integer> oneList = new ArrayList<>();
        for (int num : nums) {
            if ((num & rightMostOne) > 0) {
                oneList.add(num);
            } else {
                zeroList.add(num);
            }
        }
        int zero = 0;
        for (Integer z : zeroList) {
            zero ^= z;
        }
        int one = 0;
        for (Integer o : oneList) {
            one ^= o;
        }
        return new int[]{zero, one};
    }
}
