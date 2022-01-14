package String;

public class lc38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prevDes = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Character prev = null;
        for (int i = 0; i < prevDes.length(); i++) {
            char cur = prevDes.charAt(i);
            if (prev == null){
                prev = cur;
                count = 1;
                continue;
            }
            if (prev == cur) {
                count += 1;
            } else {
                sb.append(count);
                sb.append(prev);
                prev = cur;
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }

    public static void main(String[] args) {
        lc38 obj = new lc38();
        System.out.println(obj.countAndSay(30));
    }
}
