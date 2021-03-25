package String;

public class lc132 {
    public int minCut(String s) {
        //dp求解出s中所有的回文串
        boolean[][] palTable =new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            palTable[i][i]=true;
        }

        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i+1; j <s.length() ; j++) {
                if (j-i>1){
                    palTable[i][j]=(s.charAt(i)==s.charAt(j))&&palTable[i+1][j-1];
                }
                else {
                    palTable[i][j]=(s.charAt(i)==s.charAt(j));
                }
            }
        }

        int[] dpMin=new int[s.length()];
        dpMin[0]=0;
        for (int i = 0; i < dpMin.length; i++) {
            if (palTable[0][i]){
                dpMin[i]=0;
            }
            else {
                int min=Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (palTable[j+1][i]){
                        min=Math.min(min, 1+dpMin[j]);
                    }
                }
                dpMin[i]=min;
            }
        }
        return dpMin[dpMin.length-1];
    }
}
