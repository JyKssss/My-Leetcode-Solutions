package SystemDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class lc1244 {

}

class Leaderboard {
    TreeMap<Integer, Integer> orderMap;
    Map<Integer, Integer> map;
    public Leaderboard() {
        orderMap = new TreeMap<>();
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) {
            int oldScore = map.get(playerId);
            map.put(playerId, score);
            orderMap.put(oldScore, orderMap.get(oldScore) - 1);
            if (orderMap.get(oldScore) == 0) {
                orderMap.remove(oldScore);
            }
            score += oldScore;
            map.put(playerId, score);
            orderMap.putIfAbsent(score, 0);
            orderMap.put(score, orderMap.get(score) + 1);
        } else {
            map.put(playerId, score);
            orderMap.put(score, orderMap.getOrDefault(score, 0) + 1);
        }
    }

    public int top(int K) {
        int sum = 0;
        int prevScore = orderMap.lastKey() + 1;
        while (K > 0) {
            int curScore = orderMap.lowerKey(prevScore);
            int cnt = Math.min(K, orderMap.get(curScore));
            sum += cnt * curScore;
            K -= cnt;
            prevScore = curScore;
        }
        return sum;
    }

    public void reset(int playerId) {
        int score = map.remove(playerId);
        orderMap.put(score, orderMap.get(score) - 1);
        if (orderMap.get(score) == 0) {
            orderMap.remove(score);
        }
    }
}
