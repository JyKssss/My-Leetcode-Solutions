package Tree;

import java.util.*;

public class lc582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> childrenMap = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int id = pid.get(i);
            int fid = ppid.get(i);
            childrenMap.putIfAbsent(fid, new ArrayList<>());
            childrenMap.get(fid).add(id);
        }
        Deque<Integer> layer = new LinkedList<>();
        layer.addLast(kill);
        while (layer.size() > 0) {
            int size = layer.size();
            for (int i = 0; i < size; i++) {
                int node = layer.pollFirst();
                res.add(node);
                List<Integer> children = childrenMap.get(node);
                for (int j = 0; children != null && j < children.size(); j++) {
                    layer.addLast(children.get(i));
                }
            }
        }
        return res;
    }
}
