package Graph;

import java.util.ArrayList;
import java.util.List;

public class lc207 {
    int[] visited;
    boolean isValid=true;
    List<List<Integer>>edges;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        this.visited=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for(int[] preq: prerequisites){
            edges.get(preq[1]).add(preq[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]==0)dfs(i);
        }
        return isValid;
    }

    public void dfs(int courseNum){
        visited[courseNum]=1;
        List<Integer>edge=edges.get(courseNum);
        for(Integer e:edge){
            if (visited[e]==0){
                dfs(e);
                if (!isValid)return;
            }
            else if (visited[e]==1){
                isValid=false;

            }
        }
        visited[courseNum]=-1;
    }

}
