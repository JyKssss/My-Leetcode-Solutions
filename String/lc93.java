package String;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * IP地址 0-255 长度范围4-12  dfs
 */
public class lc93 {
    public List<String> restoreIpAddresses(String s) {
        //结果集
        List<String> res=new ArrayList<>();
        //路径集合
        Deque<Integer> path=new LinkedList<>();
        //分割次数 开始角标
        int splitTimes=0, begin=0;
        if (s.length()<4||s.length()>12) return res;
        dfs(s, begin, splitTimes, path, res);
        return res;
    }

    public int verifyIPSeg(String s){
        if (s.length()>1&&s.charAt(0)=='0')return -1;
        int ip=Integer.valueOf(s);
        if (ip>255)return -1;
        return ip;
    }

    public void dfs(String s, int begin, int splitTimes, Deque<Integer>path,List<String>res){
        if (begin==s.length()){
            if (splitTimes==4){
                StringBuffer stringBuffer=new StringBuffer();
                for(Integer integer:path){
                    stringBuffer.append(integer).append(".");
                }
                res.add(stringBuffer.substring(0, stringBuffer.length()-1).toString());
            }
        }
        if (s.length()-begin<(4-splitTimes)||s.length()-begin>(4-splitTimes)*3)return;
        for (int i = 1; i <=3 ; i++) {
            if (begin+i-1<=s.length()-1){
                int seg=verifyIPSeg(s.substring(begin, begin+i));
                if (seg!=-1){
                    path.addLast(seg);
                    dfs(s, begin+i, splitTimes+1, path, res);
                    path.removeLast();
                }
            }
            else break;
        }

    }
}
