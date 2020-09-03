package UnionFind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc547 {
    public int findCircleNum(int[][] M) {
        List<friend>friends=new ArrayList<>();
        for (int i = 0; i <M.length ; i++) {
            friends.add(new friend(i));
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (i==j)continue;
                if (M[i][j]==1){
                    friend leader1=traveseLeader(friends.get(i)),leader2=traveseLeader(friends.get(j));
                    if (leader1!=leader2)leader2.leader=leader1;
                }
            }
        }
        int count=0;
        HashSet<friend>set=new HashSet<>();
        for(friend node: friends){
            friend leader=traveseLeader(node);
            if (!set.contains(leader)){
                count++;
                set.add(leader);
            }
        }
        return count;
    }

    public friend traveseLeader(friend node){
        friend leader=null;
        while (node.leader!=null)node=node.leader;
        leader=node;
        return leader;
    }

    private class friend{
        friend leader;
        int no;
        public friend(int no,friend leader) {
            this.leader = leader;
        }

        public friend(int no) {
            this.no = no;
            this.leader=null;
        }
    }
}
