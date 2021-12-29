package Contest;

public class lc5952 {
    public int countPoints(String rings) {
        int size = rings.length() / 2;
        int[][] color = new int[10][3];
        int index = 0;
        for (int i = 0; i < size; i++) {
            char c = rings.charAt(index);
            index += 1;
            int loc = rings.charAt(index) - '0';
            if (c == 'R') {
                color[loc][0] = 1;
            } else if (c == 'G') {
                color[loc][1] = 1;
            } else {
                color[loc][2] = 1;
            }
        }
        int cnt = 0;
        for (int[] stick : color) {
            int colorCnt = 0;
            for (int i = 0; i < 3; i++) {
                if (stick[i] == 1) {
                    colorCnt += 1;
                }
            }
            if (colorCnt == 3) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
