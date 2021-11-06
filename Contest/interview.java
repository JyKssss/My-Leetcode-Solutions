package Contest;

import java.util.*;

public class interview {
    static class Solution {
        public int solution(int N) {
            // write your code in Java SE 8
            int tmp =Math.abs(N);
            LinkedList<Integer>numList=new LinkedList<>();
            while (tmp>0){
                numList.addFirst(tmp%10);
                tmp = tmp/10;
            }
            int removeIndex=-1;
            if (N>=0){
                for (int i = 0; i < numList.size(); i++) {
                    if (numList.get(i) == 5){
                        if (i+1 < numList.size() && numList.get(i+1)>5){
                            removeIndex=i;
                            break;
                        }
                    }
                }
                if (removeIndex == -1){
                    for (int i = numList.size()-1; i >=0 ; i--) {
                        if (numList.get(i) == 5){
                            removeIndex = i;
                            break;
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < numList.size(); i++) {
                    if (numList.get(i) == 5){
                        if (i+1 < numList.size() && numList.get(i+1)<5){
                            removeIndex=i;
                            break;
                        }
                    }
                }
                if (removeIndex == -1){
                    for (int i = numList.size()-1; i >=0 ; i--) {
                        if (numList.get(i) == 5){
                            removeIndex = i;
                            break;
                        }
                    }
                }
            }
            numList.remove(removeIndex);
            int res=0;
            while (numList.size()>0){
                res += numList.pollFirst();
                res *=10;
            }
            res/=10;
            if (N < 0){
                res = -res;
            }
            return res;
        }


        public int solution(String S) {
            // write your code in Java SE 8
            int upperStatus =0, lowerStatus =0 , min=201;
            for (int i = 0; i < S.length(); i++) {
                upperStatus=0;
                lowerStatus=0;
                for (int j = i; j < S.length(); j++) {
                    char cur = S.charAt(j);
                    if (cur<='Z'){
                        upperStatus = upperStatus | 1<<(cur-'A');
                    }
                    else {
                        lowerStatus = lowerStatus | 1<<(cur-'a');
                    }
                    if (lowerStatus == upperStatus){
                        min = Math.min(min, j-i+1);
                    }
                }
            }
            if (min == 201){
                return -1;
            }
            return min;

        }

    }


    public static void main(String[] args) {
        interview obj =new interview();
        int N= -5859;
        String S ="azABaabza";
        interview.Solution sol =new Solution();
        System.out.println(sol.solution(S));
    }


}




