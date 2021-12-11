package Graph;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class lc210 {
    /**
     * BFS 计算每个节点的入读和孩子 并实时更新入度 入度为0放入队列中等待取出
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        course[] coursesList = new course[numCourses];
        Deque<Integer> inD = new LinkedList<>();
        int[] res = new int[numCourses];
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            coursesList[i] = new course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int father = prerequisites[i][1];
            int kid = prerequisites[i][0];
            coursesList[father].kids.add(kid);
            coursesList[kid].indegree++;
        }
        for (int i = 0; i < coursesList.length; i++) {
            if (coursesList[i].indegree == 0) {
                inD.addLast(i);
            }
        }

        while (inD.size() > 0) {
            course cur = coursesList[inD.pollFirst()];
            for (int i = 0; i < cur.kids.size(); i++) {
                course kid = coursesList[cur.kids.get(i)];
                kid.indegree--;
                if (kid.indegree == 0) {
                    inD.addLast(kid.courseNo);
                }
            }
            res[index] = cur.courseNo;
            index++;
        }
        if (index != numCourses) {
            return new int[0];
        }
        return res;
    }
}

class course {
    int courseNo;
    int indegree;
    List<Integer> kids;

    public course(int no) {
        this.courseNo = no;
        indegree = 0;
        kids = new ArrayList<>();
    }
}

/**
 * DFS來解決這個問題
 * 每個節點有三個狀態 0表示違背訪問 1表示正在被訪問（驗證是否存在環） -1表示已經被訪問且被入棧 當節點的所有子節點都被入棧之後 將當前節點入棧
 */
class Solution {
    boolean isCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        courseDFS[] courseArray = new courseDFS[numCourses];
        Stack<Integer> resStack = new Stack<>();
        List<Integer> inD = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courseArray[i] = new courseDFS(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courseDFS kid = courseArray[prerequisites[i][0]];
            courseDFS father = courseArray[prerequisites[i][1]];
            father.kids.add(kid.courseNo);
            kid.inDegree++;
        }
        for (int i = 0; i < courseArray.length; i++) {
            if (courseArray[i].inDegree == 0) inD.add(i);
        }
        if (inD.size() == 0) return new int[0];
        for (int i = 0; i < inD.size(); i++) {
            dfs(resStack, courseArray[inD.get(i)], courseArray);
        }
        if (isCycle == true || resStack.size() < numCourses) return new int[0];
        else {
            int[] res = new int[numCourses];
            for (int i = 0; i < res.length; i++) {
                res[i] = resStack.pop();
            }
            return res;
        }
    }

    private void dfs(Stack<Integer> resStack, courseDFS cur, courseDFS[] courseArray) {
        cur.status = 1;
        List<Integer> kids = cur.kids;
        if (kids.size() == 0) {
            cur.status = -1;
            resStack.push(cur.courseNo);
        } else {
            for (int i = 0; i < kids.size(); i++) {
                if (courseArray[kids.get(i)].status == -1) {
                    continue;
                } else if (courseArray[kids.get(i)].status == 0) {
                    dfs(resStack, courseArray[kids.get(i)], courseArray);
                } else if (courseArray[kids.get(i)].status == 1) {
                    isCycle = true;
                    break;
                }
            }
            cur.status = -1;
            resStack.push(cur.courseNo);
        }
    }
}

class courseDFS {
    int courseNo;
    int status; //-1表示已经被入栈 0表示未访问 1表示正在被访问
    int inDegree;
    List<Integer> kids;

    public courseDFS(int courseNo) {
        this.courseNo = courseNo;
        this.status = 0;
        this.inDegree = 0;
        this.kids = new ArrayList<>();
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] inDegreeArr = new int[numCourses];
        List<Integer>[] preqList = new List[numCourses];
        for (int i = 0; i < preqList.length; i++) {
            preqList[i] = new LinkedList<>();
        }
        for (int[] preq : prerequisites) {
            inDegreeArr[preq[0]] += 1;
            preqList[preq[1]].add(preq[0]);
        }
        Deque<Integer> layerList = new LinkedList<>();
        for (int i = 0; i < inDegreeArr.length; i++) {
            if (inDegreeArr[i] == 0) {
                layerList.addLast(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (layerList.size() > 0) {
            int size = layerList.size();
            for (int i = 0; i < size; i++) {
                int node = layerList.pollFirst();
                res.add(node);
                List<Integer> nextCoursesList = preqList[node];
                for (int j = 0; j < nextCoursesList.size(); j++) {
                    int nextNode = nextCoursesList.get(j);
                    inDegreeArr[nextNode] -= 1;
                    if (inDegreeArr[nextNode] == 0) {
                        layerList.addLast(nextNode);
                    }
                }
            }
        }
        if (res.size() == numCourses) {
            int[] resArray = new int[numCourses];
            for (int i = 0; i < resArray.length; i++) {
                resArray[i] = res.get(i);
            }
            return resArray;
        } else {
            return new int[]{};
        }
    }
}
