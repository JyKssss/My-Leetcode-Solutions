package Contest;

public class lc5767 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] isVisited=new boolean[51];
        for (int[] range : ranges) {
            for (int i = range[0]; i <=range[1] ; i++) {
                isVisited[i-1]=true;
            }
        }

        for (int i = left; i <=right ; i++) {
            if (!isVisited[i-1]){
                return false;
            }
        }
        return true;
    }
}
