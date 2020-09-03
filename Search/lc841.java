package Search;

import java.util.HashSet;
import java.util.List;

public class lc841 {
    HashSet<Integer>visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int num=rooms.size();
        this.visited=new HashSet<>();
        dfs(rooms, 0);
        return visited.size()==rooms.size();
    }

    public void dfs(List<List<Integer>> rooms,int num){
        List<Integer>next=rooms.get(num);
        this.visited.add(num);
        for(Integer next_num:next){
            if (visited.contains(next_num))continue;
            else dfs(rooms, next_num);
        }
        return;
    }
}
