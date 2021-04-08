package Search;

import java.util.*;

public class lc843 {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String>feasibleWordsList=new ArrayList<>();
        HashSet<String>feasibleWordsSet=new HashSet<>();
        HashMap<String,Integer>wordIndexMap=new HashMap<>();
        int[][] wordsMatrix=new int[wordlist.length][wordlist.length];
        for (int i = 0; i < wordlist.length; i++) {
            feasibleWordsList.add(wordlist[i]);
            feasibleWordsSet.add(wordlist[i]);
            wordIndexMap.put(wordlist[i],i );
        }
        for (int i = 0; i < wordlist.length-1; i++) {
            wordsMatrix[i][i]=6;
            for (int j = i+1; j <wordlist.length ; j++) {
                wordsMatrix[i][j]=wordSimilarity(wordlist[i],wordlist[j] );
                wordsMatrix[j][i]=wordsMatrix[i][j];
            }
        }
        //尝试10次
        for (int i = 0; i < 10; i++) {
            if (feasibleWordsList.size()==0){
                return;
            }
            String candidateWord=findAverageWord(wordlist, feasibleWordsList, feasibleWordsSet, wordIndexMap, wordsMatrix);
//            String candidateWord=findRandomWord(feasibleWordsList);
            int equalNum= master.guess(candidateWord),index=wordIndexMap.get(candidateWord);
            if (equalNum==6){
                return;
            }
            List<String>nextWordsList=new ArrayList<>();
            HashSet<String>nextWordsSet=new HashSet<>();
            for (int j = 0; j < wordsMatrix.length; j++) {
                if (feasibleWordsSet.contains(wordlist[j])&&wordsMatrix[index][j]==equalNum){
                    nextWordsList.add(wordlist[j]);
                    nextWordsSet.add(wordlist[j]);
                }
            }
            feasibleWordsList=nextWordsList;
            feasibleWordsSet=nextWordsSet;
        }
    }

    private String findRandomWord(List<String>wordList){
        int index= (int) (Math.random()*wordList.size());
        return wordList.get(index);
    }

    private String findAverageWord(String[] wordArray,List<String>wordList, HashSet<String>wordSet, HashMap<String,Integer>wordIndesMap, int[][] wordMatrix){
        int min=101;
        String minWord=null;
        for (String s : wordList) {
            int index=wordIndesMap.get(s);
            int[] wordCnt=new int[6];
            int max=0;
            for (int i = 0; i < wordMatrix.length; i++) {
                if (wordSet.contains(wordArray[i])&&wordMatrix[index][i]!=6){
                    wordCnt[wordMatrix[index][i]]++;
                }
            }
            for (int i = 0; i < wordCnt.length; i++) {
                max=Math.max(max, wordCnt[i]);
            }
            if (max<min){
                min=max;
                minWord=s;
            }
        }
        return minWord;
    }



    private int wordSimilarity(String word1, String word2){
        int cnt=0;
        for (int i = 0; i < 6; i++) {
            if (word1.charAt(i)==word2.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }

    interface Master {
        public int guess(String word);
    }
}


