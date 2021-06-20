package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1239 {
    int len;
    public int maxLength(List<String> arr) {
        this.len=arr.size();
        return search(arr, 0, 0);
    }

    private int search(List<String> arr, int i, int m){
        if (i==len){
            return Integer.bitCount(m);
        }
        String cur=arr.get(i);
        int tmp=m;
        for (int j = 0; j < cur.length(); j++) {
            int bit=1<<(cur.charAt(j)-'a');
            if ((bit&tmp)==bit){
                return search(arr, i+1, m);
            }
            else {
                tmp|=bit;
            }
        }
        return Math.max(search(arr, i+1, m), search(arr, i+1, tmp));
    }

    public static void main(String[] args) {
        lc1239 obj=new lc1239();
        String[] strings=new String[]{"un","iq","ue"};
        List<String>list= Arrays.asList(strings.clone());
        System.out.println(obj.maxLength(list));
    }
}
