package String;

import java.util.HashMap;

public class lc205 {
    /**
     * 双Hashmap映射 但可以用一个数组来替代
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length())return false;
        if (s.length()==0&&t.length()==0)return true;
        HashMap<Character,Character>hashMap1=new HashMap<>();
        HashMap<Character,Character>hashMap2=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);
            if (hashMap1.containsKey(sChar)&&hashMap2.containsKey(tChar)){
                if (tChar!=hashMap1.get(sChar)||sChar!=hashMap2.get(tChar))return false;
                else continue;
            }
            else if (hashMap1.containsKey(sChar)||hashMap2.containsKey(tChar))return false;
            else {
                hashMap1.put(sChar, tChar);
                hashMap2.put(tChar, sChar);
            }
        }
        return true;
    }

    /**
     * 用数组实现一遍
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s.length()!=t.length())return false;
        if (s.length()==0&&t.length()==0)return true;
        int[] mapArray=new int[26];
        for (int i = 0; i < s.length(); i++) {
            mapArray[i]=-1;
        }
        for (int i = 0; i < s.length(); i++) {
            int sInt=s.charAt(i)-'a';
            int tInt=t.charAt(i)-'a';
            if (mapArray[sInt]!=-1&&mapArray[tInt]!=-1){
                if (mapArray[sInt]!=tInt||mapArray[tInt]!=sInt)return false;
                else continue;
            }
            else if (mapArray[sInt]==-1&&mapArray[tInt]==-1){
                mapArray[sInt]=tInt;
                mapArray[tInt]=sInt;
            }
            else return false;
        }
        return true;
    }


}
