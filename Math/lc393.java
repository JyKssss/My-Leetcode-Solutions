package Math;

public class lc393 {
    public boolean validUtf8(int[] data) {
        int[] masks = new int[4];
        int len = data.length, index = 0;
        for (int i = 0; i < masks.length; i++) {
            masks[i] = 1 << (7 - i);
        }
        while (index < len) {
            int l1 = 0;
            if ((masks[0] & data[index]) != masks[0]) {
                index++;
            } else {
                for (int i = 0; i < masks.length; i++) {
                    if ((masks[i] & data[index]) == masks[i]) l1++;
                    else break;
                }
                if (l1==1)return false;
                if ((1 << (7 - l1) & data[index]) != 0) return false;
                for (int i = index + 1; i < index + l1; i++) {
                    if (i >= len) return false;
                    if ((masks[0] & data[i]) != masks[0] || (masks[1] & data[i]) != 0) return false;
                }
                index += l1;
            }
        }
        return true;
    }
}
