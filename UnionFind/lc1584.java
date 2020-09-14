package UnionFind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class lc1584 {
    public int minCostConnectPoints(int[][] points) {
        int point_num=points.length;
        List<point>point_list=new ArrayList<>();
        PriorityQueue<distance> heap=new PriorityQueue<>(new Comparator<distance>() {
            @Override
            public int compare(distance o1, distance o2) {
                return o1.length-o2.length;
            }
        });
        int index=0;
        for(int[] point: points){
            point_list.add(new point(point[0],point[1],index));
            index++;
        }
        for (int i = 0; i < point_list.size()-1; i++) {
            for (int j = i+1; j <point_list.size() ; j++) {
                heap.offer(new distance(point_list.get(i), point_list.get(j)));
            }
        }
        int count=point_num,cost=0;
        while (count>1){
            distance line=heap.poll();
            point parent_x=findParent(line.x,point_list),parent_y=findParent(line.y,point_list );

            if (parent_x.no!=parent_y.no){
                cost+=line.length;
                count--;
                parent_y.parent=parent_x.no;
            }
        }
        return cost;
    }
    public point findParent(point child,List<point>point_list){
        while (child.parent!=child.no){
            child=point_list.get(child.parent);
        }
        return child;
    }
    class distance{
        int length;
        point x,y;
        public distance(point x, point y) {
            this.x = x;
            this.y = y;
            this.length=Math.abs(x.x_index-y.x_index)+Math.abs(x.y_index-y.y_index);
        }
    }
    class point{
        int x_index,y_index,parent,no;

        public point(int x_index, int y_index,int no) {
            this.x_index = x_index;
            this.y_index = y_index;
            this.no=no;
            this.parent=no;
        }
    }
}
