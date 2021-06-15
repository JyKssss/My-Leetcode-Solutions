package String;

public class lc443 {
    public int compress(char[] chars) {
        int i=0,j=0,cnt=0;
        char prev=chars[0];
        while (j<chars.length){
            if (chars[j]==prev){
                cnt++;
            }
            else {
                chars[i]=prev;
                prev=chars[j];
                i++;
                if (cnt>1){
                    String num=String.valueOf(cnt);
                    for (int k = 0; k < num.length(); k++) {
                        chars[i+k]=num.charAt(k);
                    }
                    i+=num.length();
                }
                cnt=1;
            }
            j++;
        }
        chars[i]=prev;
        i++;
        if (cnt>1){
            String num=String.valueOf(cnt);
            for (int k = 0; k < num.length(); k++) {
                chars[i+k]=num.charAt(k);
            }
            i+=num.length();
        }
        return i+1;
    }

    public static void main(String[] args) {

    }
}
