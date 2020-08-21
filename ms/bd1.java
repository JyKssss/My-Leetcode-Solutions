package ms;

import java.util.Scanner;

public class bd1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str= in.nextLine();
//        int a = in.nextInt();
//        System.out.println(a);
        System.out.println(calculate(str));

    }

    public static String calculate(String str){
        int i=0, len=str.length()-1,count=0;
        StringBuffer stringBuffer=new StringBuffer();
        char prev=' ';
        while (i<=len){
            if (i==0){
                prev=str.charAt(i);
                count++;
                i++;
            }
            else {
                if (str.charAt(i)==prev){
                    count++;
                    i++;
                }
                else {
                    stringBuffer.append(prev).append("_").append(count).append("_");
                    prev=str.charAt(i);
                    count=1;
                    i++;
                }
            }
        }
        stringBuffer.append(prev).append("_").append(count);
        return stringBuffer.toString();
    }
}
