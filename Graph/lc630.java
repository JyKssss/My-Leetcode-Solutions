package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int curTime = 0;
        for (int[] course : courses) {
            if (course[0] + curTime <= course[1]) {
                maxHeap.offer(course);
                curTime += course[0];
            } else if (maxHeap.size() > 0){
                int[] prevCourse = maxHeap.peek();
                if (prevCourse[0] > course[0]) {
                    maxHeap.poll();
                    maxHeap.offer(course);
                    curTime += (course[0] - prevCourse[0]);
                }
            }
        }
        return maxHeap.size();
    }
}
