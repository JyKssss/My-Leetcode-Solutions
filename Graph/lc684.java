package Graph;

public class lc684 {
    /**
     * 用并查集完成搜索
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        node[] nodesList = new node[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            nodesList[i + 1] = new node(i + 1);
        }

        for (int[] edge : edges) {
            int fatherL = findFatherNode(edge[0], nodesList), fatherR = findFatherNode(edge[1], nodesList);
            if (fatherL == fatherR) return edge;
            else {
                nodesList[fatherR].setFatherNode(fatherL);
            }
        }
        return null;
    }

    private int findFatherNode(int n, node[] nodeList) {
        node node = nodeList[n];
        while (node.getVal() != node.getFatherNode()) {
            node = nodeList[node.getFatherNode()];
        }
        return node.getVal();
    }

    private class node {
        int val;
        int fatherNode;

        public node(int val, int fatherNode) {
            this.val = val;
            this.fatherNode = fatherNode;
        }

        public node(int val) {
            this.val = val;
            this.fatherNode = val;
        }

        public int getVal() {
            return val;
        }

        public int getFatherNode() {
            return fatherNode;
        }

        public void setFatherNode(int fatherNode) {
            this.fatherNode = fatherNode;
        }
    }
}

