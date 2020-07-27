package Array;

import java.util.Arrays;

public class lc621 {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount=new int[26];
        for(char task: tasks){
            taskCount[task-'A']++;
        }
        Arrays.sort(taskCount);
        int max=taskCount[25],i=24;
        int count=(taskCount[25]-1)*(n+1)+1;
        while (i>=0 && taskCount[i]==max){
            count++;
            i--;
        }
        return Math.max(count, tasks.length);
    }
}
