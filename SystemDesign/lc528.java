package SystemDesign;

public class lc528 {

}
// Immutable with binary search and pre sum
class Solution {
    int[] preSumWeight;
    int range;
    public Solution(int[] w) {
        preSumWeight = new int[w.length];
        preSumWeight[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSumWeight[i] = preSumWeight[i-1] + w[i];
        }
        range = preSumWeight[w.length - 1];
    }

    public int pickIndex() {
        int random = (int) (Math.random() * range) + 1;
        int left = 0, right = preSumWeight.length - 1, mid, index = 0;
        while (left <= right) {
            mid = left + (right - left)/2;
            if (preSumWeight[mid] >= random) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
