package Graph;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc1135 {
    public int minimumCost(int n, int[][] connections) {
        if (connections.length<n-1){
            return -1;
        }
        if (n <= 1){
            return 0;
        }
        node[] nodesList = new node[n+1];
        for (int i = 1; i <= n; i++) {
            nodesList[i] = new node(i);
        }

        PriorityQueue<int[]>connectionHeap = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        for (int[] connection : connections) {
            connectionHeap.offer(connection);
        }
        int cost = 0;
        while (connectionHeap.size()>0){
            int[] connect = connectionHeap.poll();
            node n1 = nodesList[connect[0]], n2 = nodesList[connect[1]];
            if (n1.findFather().node != n2.findFather().node){
                   n2.findFather().father = n1.findFather();
                   cost += connect[2];
            }
        }

        int commonFather = nodesList[1].findFather().node;
        for (int i = 2; i <=n ; i++) {
            if (nodesList[i].findFather().node!=commonFather){
                return -1;
            }
        }
        return cost;
    }


    class node{
        private int node;
        private node father;

        node(int node){
            this.node = node;
            father = this;
        }

        public node findFather(){
            if (father.node != node){
                return father.findFather();
            }
            else {
                System.out.println();
                return father;
            }
        }

        public void setFather(node newFather){
            this.father = newFather;
        }
    }
}
