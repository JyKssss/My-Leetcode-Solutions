package GreedyAlgo;


import java.util.Arrays;


public class lc621 {
    public int leastInterval(char[] tasks, int n) {
        int[] tasksCount = new int[26];
        for (char c : tasks) tasksCount[c - 'A']++;
        Arrays.sort(tasksCount);
        int maxCount = 0;
        for (int i = tasksCount.length - 1; i >= 0; i--) {
            if (tasksCount[i] != tasksCount[25]) break;
            maxCount++;
        }
        return Math.max(tasks.length, (tasksCount[25] - 1) * (n + 1) + maxCount);
    }
}