package Graph;

import java.util.*;

public class lc269 {
    public String alienOrder(String[] words) {
        Map<Character, HashSet<Character>> orderMap = new HashMap<>();
        StringBuilder resSB = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    if (j == words[i + 1].length() -1 && words[i + 1].length() < words[i].length()) {
                        return "";
                    }
                    continue;
                }
                char l = words[i].charAt(j), h = words[i + 1].charAt(j);
                HashSet<Character> set = orderMap.getOrDefault(l, new HashSet<>());
                set.add(h);
                orderMap.put(l, set);
                break;
            }
        }

        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);
        Deque<Character> deque = new LinkedList<>();
        int count = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (inDegree[word.charAt(i) - 'a'] == -1) {
                    inDegree[word.charAt(i) - 'a'] += 1;
                    count += 1;
                }
            }
        }

        for (HashSet<Character> set : orderMap.values()) {
            for (Character character : set) {
                inDegree[character - 'a'] += 1;
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                deque.addLast((char) ('a' + i));
            }
        }

        while (deque.size() > 0) {
            char curChar = deque.pollFirst();
            resSB.append(curChar);
            HashSet<Character> set = orderMap.get(curChar);
            if (set != null && set.size() > 0) {
                for (Character nextChar : set) {
                    inDegree[nextChar - 'a'] -= 1;
                    if (inDegree[nextChar - 'a'] == 0) {
                        deque.addLast(nextChar);
                    }
                }
            }
        }
        if (resSB.length() != count) {
            return "";
        } else {
            return resSB.toString();
        }
    }
}
