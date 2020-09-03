package Graph;

import java.util.*;

public class lc332 {
    HashMap<String, PriorityQueue<String>>linkedList=new HashMap<>();
    List<String>reverseRes=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String>ticket :tickets){
            if (linkedList.containsKey(ticket.get(0)))linkedList.get(ticket.get(0)).offer(ticket.get(1));
            else {
                linkedList.put(ticket.get(0), new PriorityQueue<>());
                linkedList.get(ticket.get(0)).offer(ticket.get(1));
            }
        }

        dfs("JFK");
        Collections.reverse(reverseRes);
        return reverseRes;
    }


    public void dfs(String airport){
        while (linkedList.containsKey(airport)&&linkedList.get(airport).size()>0){
            String destination=linkedList.get(airport).poll();
            dfs(destination);
        }
        reverseRes.add(airport);
    }
}
