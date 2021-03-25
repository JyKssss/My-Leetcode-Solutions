package DynamicProgramming;

public class lc115 {
    public int numDistinct(String s, String t) {
        char[] sCharArray=s.toCharArray();
        char[] tCharArray=t.toCharArray();
        int[][] dpTable=new int[s.length()+1][t.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            dpTable[i][0]=1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <=t.length() ; j++) {
                if (j>i){
                    continue;
                }
                if (sCharArray[i-1]==tCharArray[j-1]){
                    dpTable[i][j]=dpTable[i-1][j-1]+ dpTable[i-1][j];
                }
                else {
                    dpTable[i][j]=dpTable[i-1][j];
                }
            }
        }
        return dpTable[s.length()][t.length()];
    }
}
