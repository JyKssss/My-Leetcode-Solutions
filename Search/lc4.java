package Search;

public class lc4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int left = getKthArgument(nums1, 0, len1 -1, nums2, 0, len2 - 1, (len1 + len2 + 1)/2);
        int right = getKthArgument(nums1, 0, len1 -1, nums2, 0, len2 - 1, (len1 + len2 + 2)/2);
        System.out.println(left +" "+right);
        return (left + right) * 0.5;
    }

    private int getKthArgument(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) {
            return getKthArgument(
                    nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 <= 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int mid = k/2;
        int index1 = start1 + Math.min(len1, mid) - 1;
        int index2 = start2 + Math.min(len2, mid) - 1;

        if (nums1[index1] > nums2[index2]) {
            return getKthArgument(nums1, start1, end1, nums2,
                    index2 + 1, end2, k - (index2 -start2 + 1));
        } else {
            return getKthArgument(nums1, index1 + 1, end1, nums2,
                    start2, end2, k - (index1 -start1 + 1));
        }
    }
}
