package List;

public class lc1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                leftIndex = i;
            } else break;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                rightIndex = i;
            } else break;
        }

        if (leftIndex >= rightIndex) {
            return 0;
        }
        int res = Math.min(arr.length - leftIndex - 1, rightIndex);
        int left = leftIndex;
        int right = arr.length - 1;
        while (left >= 0 && right >= rightIndex) {
            while (arr[left] <= arr[right] && right >= rightIndex) {
                right -= 1;
            }
            res = Math.min(res, right - left);
            left -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        lc1574 obj = new lc1574();
        System.out.println(obj.findLengthOfShortestSubarray(new int[]{16,10,0,3,22,1,14,7,1,12,15}));
    }
}
