package Array;

public class lc84 {
    /**
     * 暴力解法 遍历每一个矩形以其为高度计算
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int res=0;
        for (int i = 0; i < heights.length; i++) {
            int height=heights[i], j=i,width=1;
            while (--j>=0 && heights[j]>=height){
                width++;
            }
            j=i;
            while (++j<heights.length&&heights[j]>=height){
                width++;
            }
            res=Math.max(res, height*width);
        }
        return res;
    }

    /**
     * 单调栈解法
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        return 0;
    }
}
