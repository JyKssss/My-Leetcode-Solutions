package String;

import java.util.Arrays;

public class lc1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[] location = new int[]{0, 0};
        int direction = 0;


        for (int j = 0; j < instructions.length(); j++) {
            if (instructions.charAt(j) == 'G'){
                location[0] = directions[direction][0] + location[0];
                location[1] = directions[direction][1] + location[1];
            }
            else if (instructions.charAt(j) == 'R'){
                direction+=1;
                if (direction == 4){
                    direction = 0;
                }
            }
            else {
                direction-=1;
                if (direction == -1){
                    direction = 3;
                }
            }
        }

        if (location[0] == 0 && location[1] == 0){
            return true;
        }
        else {
            return direction != 0;
        }
    }
}
