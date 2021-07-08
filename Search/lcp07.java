package Search;

import java.util.*;

public class lcp07 {
    public int numWays(int n, int[][] relation, int k) {
        HashMap<Integer, List<Integer>>messageMap=new HashMap<>();
        for (int[] message : relation) {
            int start=message[0],end=message[1];
            List<Integer>endList=messageMap.getOrDefault(start, new ArrayList<>());
            endList.add(end);
            messageMap.put(start, endList);
        }

        int time=0,cnt=0,size,cur;
        Deque<Integer>stack=new LinkedList<>();
        stack.addLast(0);
        while (time<k){
            size=stack.size();
            for (int i = 0; i < size; i++) {
                cur=stack.pollFirst();
                List<Integer>destination=messageMap.get(cur);
                if (destination!=null){
                    for (Integer integer : destination) {
                        stack.addLast(integer);
                    }
                }

            }
            time++;
        }
        while (!stack.isEmpty()){
            if (stack.poll()==n-1){
                cnt++;
            }
        }
        return cnt;
    }
}
