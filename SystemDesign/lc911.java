package SystemDesign;

import java.util.TreeMap;

public class lc911 {
}

class TopVotedCandidate {
    TreeMap<Integer, Integer> orderedMap;
    public TopVotedCandidate(int[] persons, int[] times) {
        orderedMap = new TreeMap<>();
        int maxCandidate = -1, maxCount = 0;
        int[] personVote = new int[persons.length];
        for (int i = 0; i < times.length; i++) {
            int time = times[i], person = persons[i];
            personVote[person] += 1;
            if (personVote[person] >= maxCount) {
                maxCandidate = person;
                maxCount = personVote[person];
            }
            orderedMap.put(time, maxCandidate);
        }
    }

    public int q(int t) {
        return orderedMap.floorEntry(t).getValue();
    }
}
