package SystemDesign;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lc535 {
    // Encodes a URL to a shortened URL.
    HashMap<Integer,String>map=new HashMap<>();
    public String encode(String longUrl) {
        int key=longUrl.hashCode();
        map.put(key, longUrl);
        return "http://tinyurl.com/"+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String pattern=shortUrl.replace("http://tinyurl.com/", "");

        int key=Integer.parseInt(pattern);


        return map.get(key);
    }

    public static void main(String[] args) {
        lc535 l=new lc535();
        System.out.println(l.decode(l.encode("123")));
    }
}
