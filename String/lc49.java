package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Character,Integer>primeNum=new HashMap<>();
        int[] primes={3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
        char alphabet='a';
        for (int i = 0; i < primes.length; i++) {
            primeNum.put(alphabet,primes[i]);
            alphabet++;
        }
//        int i=0;
//        int prePrime=2;
//
//        primeNum.put(alphabet, prePrime);
//        while (i<25){
//            i++;
//            alphabet++;
//            while (true){
//                prePrime++;
//                boolean isPrime=true;
//                for (int j = 1; j <= (int) Math.sqrt(prePrime); j++) {
//                    if (j==1)continue;
//                    if (prePrime%j==0){
//                        isPrime=false;
//                        break;
//                    }
//                }
//                if (isPrime)break;
//            }
//            primeNum.put(alphabet, prePrime);
//            System.out.print(prePrime+",");
//        }
        HashMap<Integer,List<String>> resHash=new HashMap<>();
        for (int j = 0; j < strs.length; j++) {
            String cur=strs[j];
            int hash=1;
            for (int k = 0; k < cur.length(); k++) {
                hash=hash*primeNum.get(cur.charAt(k));
            }
            if (resHash.containsKey(hash)){
                resHash.get(hash).add(cur);
            }
            else {
                List<String>tmp=new ArrayList<>();
                tmp.add(cur);
                resHash.put(hash,tmp);
            }
        }
        List<List<String>> res=new ArrayList<>();
        for (Integer key:resHash.keySet()){
            res.add(resHash.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        lc49 l=new lc49();
        l.groupAnagrams(null);
    }
}
