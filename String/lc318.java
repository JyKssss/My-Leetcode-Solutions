package String;

public class lc318 {
    public int maxProduct(String[] words) {
        int[] bitsArray = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int bit = 0;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int mask = 1 << (word.charAt(j) - 'a');
                bit |= mask;
            }
            bitsArray[i] = bit;
        }

        int maxLength = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length ; j++) {
                if ((bitsArray[i] & bitsArray[j]) == 0) {
                    maxLength = Math.max(maxLength, words[i].length() * words[j].length());
                }
            }
        }
        return maxLength;
    }
}
