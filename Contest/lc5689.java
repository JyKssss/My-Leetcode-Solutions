package Contest;

import java.util.List;

public class lc5689 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index=ruleKey.equals("type")?0:ruleKey.equals("color")?1:2;
        int cnt=0;
        for(List<String>item:items){
            if (item.get(index).equals(ruleValue)){
                cnt++;
            }
        }
        return cnt;
    }
}
