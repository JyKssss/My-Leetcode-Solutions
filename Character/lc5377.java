package Character;

/**
 * 熟悉二进制进退位 StringBuilder的函数很好用
 * 尾数为1的时候向前进位 为0的时候抹掉最后一位
 */

public class lc5377 {
    public int numSteps(String s) {
        int global=0;
        StringBuilder sb=new StringBuilder(s);
        while (true){
            if (sb.length()==1&&sb.charAt(0)=='1'){
                return global;
            }
            if (sb.charAt(sb.length()-1)=='0'){
                sb.deleteCharAt(sb.length()-1);
                global++;
            }
            else if (sb.charAt(sb.length()-1)=='1'){
                global++;
                for (int i = sb.length()-1; i >=0 ; i--) {
                    if (i==0&&sb.charAt(0)=='1'){
                        sb.setCharAt(i, '0');
                        sb.insert(i, '1');
                        break;
                    }
                    if (sb.charAt(i)=='1'){
                        sb.setCharAt(i, '0');
                    }
                    else if (sb.charAt(i)=='0'){
                        sb.setCharAt(i, '1');
                        break;
                    }
                }
            }
        }
    }
}
