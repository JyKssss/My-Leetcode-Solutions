package String;

public class lc1576 {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '?') {
                for (int j = 0; j < 26; j++) {
                    char character = (char) ('a' + j);
                    boolean replaceable = true;
                    if (i > 0 && sb.charAt(i - 1) == character) {
                        replaceable = false;
                    }
                    if (i < sb.length() - 1 && sb.charAt(i + 1) == character) {
                        replaceable = false;
                    }
                    if (replaceable) {
                        sb.replace(i, i + 1, String.valueOf(character));
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        lc1576 obj = new lc1576();
        System.out.println(obj.modifyString("??yw?ipkj?"));
    }
}
