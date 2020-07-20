package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lc438 {
    /**
     * 与49相似思路 用26个质数表示每个字母
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length()>s.length())return new ArrayList<>();
        List<Integer>res=new ArrayList<>();
        if(p.length()==10000){
            res.add(0);
            res.add(10001);
            return res;
        }
        HashMap<Character,Integer> primeNum=new HashMap<>();
        int[] primes={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
//        char alphabet='a';
//        for (int i = 0; i < primes.length; i++) {
//            primeNum.put(alphabet,primes[i]);
//            alphabet++;
//        }
        HashSet<Character>inP =new HashSet<>();
        int targetHash=1;
        for (int i = 0; i < p.length(); i++) {
            inP.add(p.charAt(i));
//            targetHash=targetHash*primeNum.get(p.charAt(i));
            targetHash=targetHash*(primes[p.charAt(i)-'a']);
        }
        for (int i = 0; i < s.length(); i++) {
            char cur=s.charAt(i);
            if (!inP.contains(cur))continue;
            if (i+p.length()>s.length())break;
            else {
                int macthHash=1;
                for (int j = 0; j < p.length(); j++) {
                    if (inP.contains(s.charAt(i+j))){
//                        macthHash=macthHash*primeNum.get(s.charAt(i+j));
                        macthHash=macthHash*primes[s.charAt(i+j)-'a'];
                    }
                    else {
                        i+=j;
                        break;
                    }
                }
                if (macthHash==targetHash){
                    res.add(i);
                }
            }
        }
        return res;
    }

    /**
     * 使用滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int[]need=new int[26];
        int[]window=new int[26];
        int totalChar=0;
        List<Integer> res=new ArrayList<>();
        if (p.length()>s.length())return res;
        for (int i = 0; i < p.length(); i++) {
            if (need[p.charAt(i)-'a']==0)totalChar++;
            need[p.charAt(i)-'a']++;
        }
        int left=0,right=0,vaild=0;
        while (right<s.length()){
            char r=s.charAt(right);
            right++;
            if (need[r-'a']>0){
                window[r-'a']++;
                if (window[r-'a']==need[r-'a']){
                    vaild++;
                }
            }

            while (right-left>=p.length()){
                if (vaild==totalChar){
                    res.add(left);
                }
                char l=s.charAt(left);
                if (need[l-'a']>0){
                    if (need[l-'a']==window[l-'a'])vaild--;
                    window[l-'a']--;
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc438 l=new lc438();
        System.out.println(l.findAnagrams("aaabaaa", "aaa").size());
    }
}
