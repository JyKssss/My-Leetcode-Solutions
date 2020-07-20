package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lc556 {
 //题目翻译过来就是用同样的数字找最小的比他本身大的数

    /**
     * 先找到字符串中不符合从右到左递增的第一个数 和右侧的最小的最大数进行交换 之后再对右侧数字进行排序 注意char和int类型的转换
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        String string=String.valueOf(n);
        int pre=Integer.valueOf(string.charAt(string.length()-1));
        int index;
        boolean isreverse=false;
        for ( index = string.length()-1; index >=0 ; index--) {
            int cur=Integer.valueOf(string.charAt(index));
            if (cur>=pre){
                pre=cur;
                continue;
            }
            else {
                isreverse=true;
                pre=cur;
                break;
            }
        }
//        System.out.println(string+" "+index+" "+isreverse);
        if (isreverse==false)return -1;
        else {
            int swIndex=0;
            for (int i = string.length()-1 ; i >index ; i--) {
                if (Integer.valueOf(string.charAt(i))>pre){
                    swIndex=i;
                    break;
                }
            }
            char[] chars=string.toCharArray();
            char tmp=chars[swIndex];
//            System.out.println(swIndex+" "+tmp);
            chars[swIndex]=chars[index];
            chars[index]=tmp;
//            System.out.println(String.valueOf(chars));
            //交换后对后面的进行升序序排序
            String str=String.valueOf(chars);
            String toSort=str.substring(index+1);
            String preStr=str.substring(0, index+1);
            System.out.println(toSort+" "+preStr);
            System.out.println(str+" "+toSort);
            List<Integer> integerList=new ArrayList<>();
            for (int i = 0; i < toSort.length(); i++) {
                integerList.add(Integer.valueOf(toSort.charAt(i)-'0'));
            }
            Collections.sort(integerList);
            StringBuffer stringBuffer=new StringBuffer();
            for (int i = 0; i < integerList.size(); i++) {
                stringBuffer.append(integerList.get(i));
            }
            Long test=Long.valueOf(preStr.concat(stringBuffer.toString()));
            if (test>Integer.MAX_VALUE)return -1;
            return Integer.valueOf(preStr.concat(stringBuffer.toString()));
        }
    }

}
