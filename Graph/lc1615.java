package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lc1615 {
    public int maximalNetworkRank(int n, int[][] roads) {

        boolean[][]matrix=new boolean[n][n];
        int[] indegree=new int[n];
        int largest=-1,secLargest=-2,res=0;
        for (int[] road : roads) {
            matrix[road[0]][road[1]]=true;
            matrix[road[1]][road[0]]=true;
            indegree[road[0]]++;
            indegree[road[1]]++;

        }

        for (int degree : indegree) {
            if (degree>largest){
                secLargest=largest;
                largest=degree;

            }
            else if (degree>secLargest&&degree<=largest){
                secLargest=degree;
            }

        }

        List<Integer>largestCity=new ArrayList<>();
        List<Integer>secLargestCity=new ArrayList<>();
        if (largest==secLargest){
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i]==largest){
                    largestCity.add(i);
                }
            }

            for (int i = 0; i < largestCity.size()-1; i++) {
                for (int j = i+1; j <largestCity.size() ; j++) {
                    if (matrix[largestCity.get(i)][largestCity.get(j)]){
                        res=largest*2-1;
                    }
                    else {
                        return 2*largest;
                    }
                }
            }

        }
        else {
            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i]==largest){
                    largestCity.add(i);
                }
                else if (indegree[i]==secLargest){
                    secLargestCity.add(i);
                }
            }
            for (int i = 0; i < largestCity.size(); i++) {
                for (int j = 0; j < secLargestCity.size(); j++) {
                    if (matrix[largestCity.get(i)][secLargestCity.get(j)]){
                        res=largest+secLargest-1;
                    }
                    else {
                        return largest+secLargest;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] roads=new int[][]{{0,1},{0,3},{1,2},{1,3}};
        lc1615 obj=new lc1615();
        System.out.println(obj.maximalNetworkRank(4, roads));
    }
}
