package List;

import java.util.Deque;
import java.util.LinkedList;

public class lc649 {
    public String predictPartyVictory(String senate) {
        int countRadiant=0,countDire=0;
        Deque<Integer> radiantList =new LinkedList<>();
        Deque<Integer> direList =new LinkedList<>();
        for (int i = 0; i <senate.length() ; i++) {
            Character character=senate.charAt(i);
            if (character.equals('R')){
                countRadiant++;
                radiantList.addLast(i);
            }
            else {
                countDire++;
                direList.addLast(i);
            }
        }
        while (countDire>0&&countRadiant>0){
            if (radiantList.peekFirst()>direList.peekFirst()){
                int df=direList.removeFirst();
                radiantList.removeFirst();
                countRadiant--;
                direList.addLast(df+senate.length());
            }
            else {
                int rf=radiantList.removeFirst();
                direList.removeFirst();
                countDire--;
                radiantList.addLast(rf+senate.length());
            }
        }

        if (countDire>0)return "Dire";
        else return "Radiant";
    }
}
