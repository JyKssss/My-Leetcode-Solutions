package Contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lc5806 {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<int[]>inOutList=new ArrayList<>();
        List<List<Long>>res=new ArrayList<>();
        for (int[] segment : segments) {
            inOutList.add(new int[]{segment[2],segment[0]});
            inOutList.add(new int[]{segment[2],-segment[1]});
        }
        Collections.sort(inOutList, (o1, o2) -> {
            if (Math.abs(o1[1])!=Math.abs(o2[1])){
                return Math.abs(o1[1])-Math.abs(o2[1]);
            }
            else {
                return o1[1]-o2[1];
            }
        });

        int start=inOutList.get(0)[1],index=0,time;
        long cnt=0;
        while (index<inOutList.size()){
            if (index==0){
                time=inOutList.get(index)[1];
                while (index<inOutList.size()&&inOutList.get(index)[1]==time){
                    cnt+=inOutList.get(index)[0];
                    index++;
                }
            }
            else {
                time=inOutList.get(index)[1];
                List<Long>list=new ArrayList<>();
                list.add((long) start);
                list.add((long) Math.abs(time));
                list.add(cnt);
                res.add(list);
                start=Math.abs(time);
                while (index<inOutList.size()&&Math.abs(inOutList.get(index)[1])==Math.abs(time)){
                    cnt+=inOutList.get(index)[1]>0?inOutList.get(index)[0]:-inOutList.get(index)[0];
                    index++;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc5806 obj=new lc5806();
        int[][]segement=new int[][]{{1,4,5},{2,4,5},{6,8,9}};
        System.out.println(obj.splitPainting(segement));
    }
}
