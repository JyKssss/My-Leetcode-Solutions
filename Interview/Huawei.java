package Interview;

import java.util.*;

public class Huawei {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt(), startX = in.nextInt(), startY = in.nextInt(),
                endX = in.nextInt(), endY = in.nextInt(), numLake = in.nextInt();
        HashSet<int[]> lakeSet = new HashSet<>();
        for(int i =0; i < numLake; i++){
            int lakeX = in.nextInt(), lakeY = in.nextInt();
            int [] lakeArray = new int[]{lakeX, lakeY};
            lakeSet.add(lakeArray);
        }

        int[] res = minRoute(lakeSet,m,n,startX, startY, endX, endY);
        System.out.println(res[0]+" "+res[1]);
        return;
    }

    public static int[] minRoute(HashSet<int[]> lakeSet, int m, int n, int startX, int startY, int endX, int endY){
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] map = new int[m][n], cntMap = new int[m][n];
        int[] start = new int[]{startX, startY}, end = new int[]{endX, endY};
        int length = 0;
        HashSet<int[]> visitedSet = new HashSet<>();
        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(start);
        visitedSet.add(start);
        cntMap[startX][startY] = 1;


        while(list.size()>0){
            int size = list.size();
            List<int[]> curList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                int[] curNode = list.pollFirst();

                Set<int[]> layerSet = new HashSet<>();
                if(curNode[0] == endX && curNode[1] == endY){
                    return new int[]{cntMap[endX][endY], length};
                }
                for(int[] dirction : directions){
                    int [] nextNode = new int[]{curNode[0]+dirction[0], curNode[1]+dirction[1]};
                    if(visitedSet.contains(nextNode) || lakeSet.contains(nextNode)){
                        continue;
                    }
                    if(!layerSet.contains(nextNode)){
                        list.addLast(nextNode);
                        layerSet.add(nextNode);
                        curList.add(nextNode);
                    }


                    cntMap[nextNode[0]][nextNode[1]] += cntMap[curNode[0]][curNode[1]];

                }

                for(int[] cur: curList){
                    visitedSet.add(cur);
                }
            }
            length +=1;
        }
        return null;
    }
}
