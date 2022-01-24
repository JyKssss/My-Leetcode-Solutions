package Math;

public class lc670 {
    public int maximumSwap(int num) {
        String numString = String.valueOf(num);
        char[] numArray = numString.toCharArray();
        int[][] preLarge = new int[numString.length()][2];
        preLarge[numString.length() - 1][0] = (int) numString.charAt(numString.length() - 1);
        preLarge[numString.length() - 1][1] = numString.length() - 1;
        for (int i = numString.length() - 2; i >= 0 ; i-= 1) {
            int curNum = (int) numString.charAt(i);
            if (curNum > preLarge[i + 1][0]) {
                preLarge[i][0] = curNum;
                preLarge[i][1] = i;
            } else {
                preLarge[i][0] = preLarge[i + 1][0];
                preLarge[i][1] = preLarge[i + 1][1];
            }
        }

        for (int i = 0; i < numString.length(); i++) {
            int curNum = (int) numString.charAt(i);
            if (curNum < preLarge[i][0]) {
                char tmp = numArray[i];
                numArray[i] = numArray[preLarge[i][1]];
                numArray[preLarge[i][1]] = tmp;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(numArray));
    }
}
