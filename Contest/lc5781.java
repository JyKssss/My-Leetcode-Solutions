package Contest;

public class lc5781 {
    public String removeOccurrences(String s, String part) {
        int len=part.length();
        while (s.contains(part)){
            int startIndex=s.indexOf(part);
            s=s.substring(0, startIndex)+s.substring(startIndex+len);
        }
        return s;
    }
}
