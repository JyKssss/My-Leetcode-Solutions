package Tree;


public class lc427 {
    public Node construct(int[][] grid) {
        int x0 = 0, y0 = 0, x1 = grid.length - 1, y1 = grid[0].length - 1;
        return recurse(grid, x0, y0, x1, y1);
    }

    private Node recurse(int[][] grid, int x0, int y0, int x1, int y1) {
        boolean isSame = true;
        int number = grid[x0][y0];
        for (int i = x0; i <= x1 ; i++) {
            for (int j = y0; j <= y1 ; j++) {
                if (grid[i][j] != number) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            return new Node(number > 0, true);
        } else {
            Node topLeft = recurse(grid, x0, y0, x0 + (x1 - x0) / 2, y0 + (y1 - y0) / 2);
            Node topRight = recurse(grid, x0, y1 - (y1 - y0) / 2, x0 + (x1 - x0) / 2, y1);
            Node bottomLeft = recurse(grid, x1 - (x1 - x0) / 2, y0, x1, y0 + (y1 - y0) / 2);
            Node bottomRight = recurse(grid, x1 - (x1 - x0) / 2, y1 - (y1 - y0) / 2, x1, y1);
            return new Node(number > 0, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
