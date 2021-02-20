package DynamicProgramming;

public class lc72 {
    public int minDistance(String word1, String word2) {
        int[][] dpTable=new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length()+1; i++) {
            dpTable[i][0]=i;
        }
        for (int i = 0; i < word2.length()+1; i++) {
            dpTable[0][i]=i;
        }
        for (int i = 1; i <word1.length()+1 ; i++) {
            for (int j = 1; j <word2.length()+1 ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dpTable[i][j]=dpTable[i-1][j-1];
                }
                else {
                    dpTable[i][j]=Math.min(dpTable[i-1][j-1]+1,Math.min(dpTable[i-1][j]+1, dpTable[i][j-1]+1));
                }
            }
        }
        return dpTable[word1.length()][word2.length()];
    }
}
